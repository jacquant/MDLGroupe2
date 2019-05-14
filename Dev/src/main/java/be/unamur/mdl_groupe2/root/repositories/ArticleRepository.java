package be.unamur.mdl_groupe2.root.repositories;

import be.unamur.mdl_groupe2.root.models.article.Article;
import be.unamur.mdl_groupe2.root.models.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * The interface Article repository.
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    // List<Article> findArticlesByTagContains(String[] tags);
    List<Article> findArticlesByTitleContains(String title);
    List<Article> findArticlesByTitleLike(String title);
    List<Article> findArticleByDomainIn(String string);
    /**
     * Find article write by list.
     *
     * @param author
     * @return the list
     */
    List<Article> findArticlesByAuthor(Author author);


    /**
     * Find article with title list.
     *
     * @param title
     * @return the list
     */
//TODO protect against SQL injection
    @Query(value = "SELECT u FROM Article u WHERE u.title LIKE %?1%")
    List<Article> findArticleWithTitle(String title);


    /**
     * Find article with tag list.
     *
     * @param tag the tag
     * @return the list
     */
//TODO protect against SQL injection
    //TODO Tag est stocké comme un tableau de string en BD
    @Query(value = "SELECT u FROM Article u WHERE u.tag LIKE %?1%")
    List<Article> findArticleWithTag(String tag);


}
