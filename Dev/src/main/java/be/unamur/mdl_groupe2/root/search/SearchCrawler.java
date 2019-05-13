package be.unamur.mdl_groupe2.root.search;

import be.unamur.mdl_groupe2.root.exception.MetricNotAvailableException;
import be.unamur.mdl_groupe2.root.exception.NotAuthorizedException;
import be.unamur.mdl_groupe2.root.models.article.Article;
import be.unamur.mdl_groupe2.root.models.articleRef.ArticleRef;
import be.unamur.mdl_groupe2.root.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * The type Search crawler.
 */
/*
    This class is in charge to explore and update the information for ranking.
    The searchCrawler need to be called once a day.
 */
@Component
public class SearchCrawler {

    @Autowired
    private ArticleRepository repository;

    /**
     * Search crawler.
     */
    @Scheduled(cron = "0 0 3")
    public void SearchCrawler() {

        for (Article article : repository.findAll()) {
            try {
                article.setMetric(getMetricsFromWeb(article));
            } catch (MetricNotAvailableException | NotAuthorizedException e) {
                article.setMetric(getMetricsFromPlateform(article));
            }
        }
    }

    /**
     *
     * @param article
     * @return
     */
    private int getMetricsFromPlateform(Article article) {
        int i = 0;
        for (Article allArticle : repository.findAll()) {

            for (ArticleRef articleRefBiblo : allArticle.getBibliography()) {
                Article articleRef = articleRefBiblo.getArticle();
                if (articleRef.getRef().equals(article.getRef())) {
                    i++;
                }
            }
        }
        return i;
    }

    /**
     *
     * @param article
     * @return
     * @throws MetricNotAvailableException
     * @throws NotAuthorizedException
     */
    private int getMetricsFromWeb(Article article) throws MetricNotAvailableException, NotAuthorizedException {
        String ref = article.getRef();

        String ieeePatern = "ieee" ;
        String acmPatern = "acm";
        String curlResult;
        int metrics = 0;


        try{
            curlResult = curlWeb(ref);
            if(ref.contains(ieeePatern)){
                metrics = cleanWebResultIEEE(curlResult);
            } else if (ref.contains(acmPatern)){
                metrics = cleanWebResultACM(curlResult);
            } else {
                throw new MetricNotAvailableException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return metrics;
    }

    /**
     *
     * @param ref
     * @return
     * @throws Exception
     */
    private String curlWeb(String ref) throws Exception{

        StringBuilder result = new StringBuilder();
        URL url = new URL(ref);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();

        return result.toString();
    }

    /**
     *
     * @param webPage
     * @return
     */
    private int cleanWebResultIEEE(String webPage){
        int tmp;

        String pattern = "\"citationCountPaper\":";
        tmp = webPage.lastIndexOf(pattern);
        String TrimmedBefore = webPage.substring(tmp);

        tmp = TrimmedBefore.indexOf(":");
        String Trimmedtmp = TrimmedBefore.substring(tmp+1);

        tmp = Trimmedtmp.indexOf(",");
        String Trimmed = Trimmedtmp.substring(0,tmp);

        return Integer.parseInt(Trimmed);
    }

    /**
     *
     * @param webPage
     * @return
     * @throws NotAuthorizedException
     */
    private int cleanWebResultACM(String webPage) throws NotAuthorizedException{
        throw new NotAuthorizedException("https://libraries.acm.org/digital-library/policies");
    }

}
