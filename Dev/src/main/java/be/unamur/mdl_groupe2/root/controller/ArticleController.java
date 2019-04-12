package be.unamur.mdl_groupe2.root.controller;


import be.unamur.mdl_groupe2.root.model.Article;
import be.unamur.mdl_groupe2.root.repository.ArticleRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticleController {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    @PostMapping("/articles")
    public Article create(@RequestBody Article article) {
        return articleRepository.save(article);
    }

    @GetMapping("/articles")
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @GetMapping("/articles/{article_id}")
    public Article findByArticleId(@PathVariable("article_id") Long articleId) {
        return articleRepository.getOne(articleId);
    }

    @GetMapping("/articles/pageRankArticle")
    public List<Article> pageRankArticle(ArticleRepository articleRepository) { return articleRepository.findAll(Sort.by(Sort.Direction.ASC,"title")); }

    @PutMapping("/articles/{article_id}")
    public Article update(@PathVariable("article_id") Long articleID, @RequestBody Article articleObject) {
        Article article = articleRepository.getOne(articleID);
        article.setAuthor(articleObject.getAuthor());
        article.setTitle(articleObject.getTitle());
        article.setDomain(articleObject.getDomain());
        article.setTag(articleObject.getTag());
        article.setPublished(articleObject.getPublished());
        article.setAbstractArticle(articleObject.getAbstractArticle());
        // article.setPdfFiles(articleObject.getPdfFiles());
        article.setVideoUrl(articleObject.getVideoUrl());
        article.setTag(articleObject.getTag());
        article.setJournal(articleObject.getJournal());
        article.setPublisher(articleObject.getPublisher());
        return articleRepository.save(article);
    }

    @DeleteMapping("/articles/{article_id}")
    public List<Article> delete(@PathVariable("article_id") Long articleID) {
        articleRepository.deleteById(articleID);
        return articleRepository.findAll();
    }

    @PutMapping("/article/{article_id}")
    public Article SetMetrics(@PathVariable("article_id")Long articleID, @RequestBody Article articleObject){
        Article article = articleRepository.getOne(articleID);
        article.setMetric(articleObject.getMetric());
        return articleRepository.save(article);
    }

}
