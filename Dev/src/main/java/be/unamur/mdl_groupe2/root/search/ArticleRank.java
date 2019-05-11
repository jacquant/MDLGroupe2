package be.unamur.mdl_groupe2.root.search;

import be.unamur.mdl_groupe2.root.models.article.Article;
import be.unamur.mdl_groupe2.root.repositories.ArticleRepository;
import org.jgrapht.Graph;
import org.jgrapht.alg.scoring.PageRank;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Map;



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
public class ArticleRank{

    @Autowired
    private ArticleRepository repository;
    private int[] matrice;

    /**
     *  Pre : metrics are update.
     *  Post : Pagerank is update based on metrics scores.
     */
    @Scheduled(cron = "0 0 4")
    public void ArticleRank(){
        Map<Long,Long> scores = new PageRank(GraphCreation(),0.85,10).getScores();
        repository.findAll().forEach(article -> {
            article.setPagerankscore(scores.getOrDefault(article.getId(),(long)1));
        });
    }

    /**
     * Pre : repository is initialised
     * Post :  a Graph is create based on repository relation
     * @return a Graph based on article
     */
    /*
    private Graph GraphCreation() {
        Graph g = new Graph();
        repository.findAll().forEach(article -> {
            g.addVertex(article.getId().toString(),article.getMetric());
            article.getBibliography().forEach(articleRef -> {
                //Creation of a Vertex for each reference
                g.addVertex(articleRef.toString(),articleRef.getArticle().getMetric());
                //Creation of a edge between source and referenced
                g.addEdge(article.getId().toString(), articleRef.toString(),(long)article.getMetric(),(long)articleRef.getArticle().getMetric());
            });
        });

        return g;
    }*/

    private Graph GraphCreation(){
        Graph<Long,DefaultEdge > g = new DefaultDirectedGraph<>(DefaultEdge.class);
        repository.findAll().forEach(article -> {
            g.addVertex(article.getId());
            article.getBibliography().forEach(articleRef -> {
                //Creation of a Vertex for each reference
                g.addVertex(articleRef.getArticle().getId());
                //Creation of a edge between source and referenced
                g.addEdge(article.getId(), articleRef.getArticle().getId());
            });
        });
        return g;
    }


}