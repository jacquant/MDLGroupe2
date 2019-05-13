package be.unamur.mdl_groupe2.root.repositories;

import be.unamur.mdl_groupe2.root.models.article.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * The interface Article repository.
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    /**
     * Find article write by list.
     *
     * @param id the id
     * @return the list
     */
//TODO protect against SQL injection
    @Query(value = "SELECT u FROM Article u WHERE u.author LIKE %?1%")
    List<Article> findArticleWriteBy(Long id);


    /**
     * Find article with title list.
     *
     * @param title the title
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
