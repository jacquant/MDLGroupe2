package be.unamur.mdl_groupe2.root.search;

import be.unamur.mdl_groupe2.root.repositories.ArticleRepository;
import org.jetbrains.annotations.Contract;
import org.jgrapht.Graph;
import org.jgrapht.alg.scoring.PageRank;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ArticleRank{

    private final ArticleRepository repository;
    private int[] matrice;

    @Contract(pure = true)
    @Autowired
    public ArticleRank(ArticleRepository repository) {
        this.repository = repository;
    }

    /**
     *  Pre : metrics are update.
     *  Post : Pagerank is update based on metrics scores.
     */
    @Scheduled(cron = "0 0 4")
    public void Ranking(){
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