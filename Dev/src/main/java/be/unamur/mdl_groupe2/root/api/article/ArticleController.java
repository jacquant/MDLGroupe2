package be.unamur.mdl_groupe2.root.api.article;


import be.unamur.mdl_groupe2.root.models.article.Article;
import be.unamur.mdl_groupe2.root.repositories.ArticleRepository;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Article controller.
 */
@RestController
@RequestMapping("/api")
public class ArticleController {

    private final ArticleRepository articleRepository;

    /**
     * Instantiates a new Article controller.
     *
     * @param articleRepository the article repository
     */
    //@Contract(pure = true)
    @Autowired
    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    // ===============================
    // GET

    /**
     * Find all list.
     *
     * @return the list
     */
    @GetMapping("/articles")
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    /**
     * Find article write by list.
     *
     * @param author the author
     * @return the list
     */
    @GetMapping("/articles/with_author/{author}")
    public List<Article> findArticleWriteBy(@PathVariable("author") Long author) {
        return this.articleRepository.findArticleWriteBy(author);
    }

    /**
     * Find article with title list.
     *
     * @param title the title
     * @return the list
     */
    @GetMapping("/articles/with_title/{title}")
    public List<Article> findArticleWithTitle(@PathVariable("title") String title) {
        return this.articleRepository.findArticleWithTitle(title);
    }

    /**
     * Find article with tag list.
     *
     * @param tag the tag
     * @return the list
     */
    @GetMapping("/articles/with_tag/{tag}")
    public List<Article> findArticleWithTag(@PathVariable("tag") String tag) {
        return this.articleRepository.findArticleWithTag(tag);
    }

    /**
     * Find by article id article.
     *
     * @param articleId the article id
     * @return the article
     */
    @GetMapping("/articles/with_id/{article_id}")
    public Article findByArticleId(@PathVariable("article_id") Long articleId) {
        return articleRepository.getOne(articleId);
    }

    /**
     * Page rank article list.
     *
     * @return the list
     */
    @GetMapping("/articles/pageRankArticle")
    public List<Article> pageRankArticle() {
        return articleRepository.findAll(Sort.by(Sort.Direction.ASC, "title"));
    }

    // ===============================
    // POST

    /**
     * Create article.
     *
     * @param article the article
     * @return the article
     */
    @PostMapping("/articles")
    public Article create(@RequestBody Article article) {
        return articleRepository.save(article);
    }

    /**
     * Contribution boolean.
     *
     * @param articleID the article id
     * @return the boolean
     */
    @GetMapping("article/contribution/{article_id}")
    public Boolean Contribution(@PathVariable("article_id") Long articleID) {
        Article articleObject = articleRepository.getOne(articleID);
        return articleObject.getAuthorizedContribution();
    }

// ===============================
    // PUT

    /**
     * Update article.
     *
     * @param articleID     the article id
     * @param articleObject the article object
     * @return the article
     */
    @PutMapping("/articles/{article_id}")
    public Article update(@PathVariable("article_id") Long articleID, @NotNull @RequestBody Article articleObject) {
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
        article.setAuthorizedContribution(articleObject.getAuthorizedContribution());
        article.setContributionUnderSupervision(articleObject.getContributionUnderSupervision());



        return articleRepository.save(article);
    }

    /**
     * Set metrics article.
     *
     * @param articleID     the article id
     * @param articleObject the article object
     * @return the article
     */
    @PutMapping("/article/metrics/{article_id}")
    public Article SetMetrics(@PathVariable("article_id") Long articleID, @NotNull @RequestBody Article articleObject) {
        Article article = articleRepository.getOne(articleID);
        article.setMetric(articleObject.getMetric());
        return articleRepository.save(article);
    }

// ===============================
    // DELETE

    /**
     * Delete list.
     *
     * @param articleID the article id
     * @return the list
     */
    @DeleteMapping("/articles/{article_id}")
    public List<Article> delete(@PathVariable("article_id") Long articleID) {
        articleRepository.deleteById(articleID);
        return articleRepository.findAll();
    }
    // ===============================
}
