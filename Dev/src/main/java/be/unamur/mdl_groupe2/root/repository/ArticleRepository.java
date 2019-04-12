package be.unamur.mdl_groupe2.root.repository;

import be.unamur.mdl_groupe2.root.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query(value = "SELECT u FROM article u WHERE u.author=?1")
    List<Article> findArticleWriteBy(Long id);

}
