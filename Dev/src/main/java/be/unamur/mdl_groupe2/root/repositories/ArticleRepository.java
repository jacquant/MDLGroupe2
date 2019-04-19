package be.unamur.mdl_groupe2.root.repositories;

import be.unamur.mdl_groupe2.root.models.article.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    //TODO protect against SQL injection
    @Query(value = "SELECT u FROM Article u WHERE u.author=?1")
    List<Article> findArticleWriteBy(Long id);


    //TODO protect against SQL injection
    @Query(value = "SELECT u FROM Article u WHERE u.title=?1")
    List<Article> findArticleWithTitle(String title);


    //TODO protect against SQL injection
    //TODO Tag est stocké comme un tableau de string en BD
    @Query(value = "SELECT u FROM Article u WHERE u.tag=?1")
    List<Article> findArticleWithTag(String tag);

}
