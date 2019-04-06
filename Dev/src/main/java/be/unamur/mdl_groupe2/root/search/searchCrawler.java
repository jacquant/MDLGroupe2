package be.unamur.mdl_groupe2.root.search;

import be.unamur.mdl_groupe2.root.exception.MetricNotAvailableException;
import be.unamur.mdl_groupe2.root.exception.NotAuthorizedException;
import be.unamur.mdl_groupe2.root.controller.ArticleController;
import be.unamur.mdl_groupe2.root.model.Article;
import be.unamur.mdl_groupe2.root.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;

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

    @Scheduled(cron = "0 0 3")
    public void SearchCrawler() {/*
        List<Article> lists = ArticleController.findAll();

        for( Article article : lists){
            try {
                ArticleController.SetMetric(getMetricsFromWeb(article));
            } catch (MetricNotAvailableException | NotAuthorizedException e) {
                ArticleController.SetMetric(getMetricsFromPlateform(article));
            }
        }*/
    }

    private int getMetricsFromPlateform(Article article) {
        //TODO implements plateform metrics depends of reference syntax
        return 0;
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
