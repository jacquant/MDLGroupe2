package be.unamur.mdl_groupe2.root.search;

import be.unamur.mdl_groupe2.root.controller.ArticleController;
import be.unamur.mdl_groupe2.root.exception.MetricNotAvailableException;
import be.unamur.mdl_groupe2.root.exception.NotAuthorizedException;
import be.unamur.mdl_groupe2.root.model.Article;
import be.unamur.mdl_groupe2.root.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/*
    This class is in charge to explore and update the information for ranking.
    The searchCrawler need to be called once a day.
 */

public class SearchCrawler {

    @Autowired
    private ArticleRepository repository;

    @Scheduled(cron = "0 0 3")
    public void SearchCrawler() {

        for (Article article : repository.findAll()) {
            try {
                article.setMetric(getMetricsFromWeb(article));
            } catch (MetricNotAvailableException | NotAuthorizedException e) {
                article.setMetric(getMetricsFromPlateform(article));
            }
        }

        for (Article article : repository.findAll()) {
            long score = 0;
            for(Article articleref : article.getBibliography()) {
                int metrics = articleref.getMetric();
                if (metrics != 0)
                    score = score + articleref.getPagerankscore()/ metrics;
            }
            article.setPagerankscore(score);
        }
    }

    private int getMetricsFromPlateform(Article article) {
        int i = 0;
        for (Article allArticle : repository.findAll()) {

            for(Article articlebiblo: allArticle.getBibliography()){
                if (article.getRef().equals(article.getRef())){
                    i++;
                }
            }
        }
        return i;
    }

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

    private int cleanWebResultIEEE(String webPage){
        int tmp=0;

        String pattern = "\"citationCountPaper\":";
        tmp = webPage.lastIndexOf(pattern);
        String TrimmedBefore = webPage.substring(tmp);

        tmp = TrimmedBefore.indexOf(":");
        String Trimmedtmp = TrimmedBefore.substring(tmp+1);

        tmp = Trimmedtmp.indexOf(",");
        String Trimmed = Trimmedtmp.substring(0,tmp);

        return Integer.parseInt(Trimmed);
    }

    private int cleanWebResultACM(String webPage) throws NotAuthorizedException{
        throw new NotAuthorizedException("https://libraries.acm.org/digital-library/policies");
    }

}
