package be.unamur.mdl_groupe2.root.search;

import be.unamur.mdl_groupe2.root.api.article.ArticleController;
import be.unamur.mdl_groupe2.root.models.article.Article;
import be.unamur.mdl_groupe2.root.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;


/*
    This class is in charge to create a index based on metrics.
 */
/*
OLD VERSION
public class PageRank extends ArticleController {

    public PageRank(ArticleRepository articleRepository) {
        super(articleRepository);
    }

    @Override
    public List<Article> pageRankArticle(ArticleRepository articleRepository){
        return articleRepository.findAll(Sort.by(Sort.Direction.ASC,"metric"));
    }
}
*/

/*         for (Article article : repository.findAll()) {
            long score = 0;
            for (ArticleRef articleRef : article.getBibliography()) {
                Article article_1 = articleRef.getArticle();
                int metrics = article_1.getMetric();
                if (metrics != 0)
                    score = score + article_1.getPagerankscore() / metrics;
            }
            article.setPagerankscore(score);
        }

 */
public class PageRank{

    @Autowired
    private ArticleRepository repository;

    /**
     *  Pre : metrics are uptodate.
     *  Post : Pagerank is uptodate based on metrics scores.
     */
    @Scheduled(cron = "0 0 4")
    public  void PageRank(){
        //TODO
        
    }


}