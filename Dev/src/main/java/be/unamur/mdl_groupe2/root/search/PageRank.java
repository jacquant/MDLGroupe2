package be.unamur.mdl_groupe2.root.search;

import be.unamur.mdl_groupe2.root.controller.ArticleController;
import be.unamur.mdl_groupe2.root.model.Article;
import be.unamur.mdl_groupe2.root.repository.ArticleRepository;
import org.springframework.data.domain.Sort;

import java.util.List;


/*
    This class is in charge to create a index based on metrics.
 */

public class PageRank extends ArticleController {

    public PageRank(ArticleRepository articleRepository) {
        super(articleRepository);
    }

    @Override
    public List<Article> pageRankArticle(ArticleRepository articleRepository){
        return articleRepository.findAll(Sort.by(Sort.Direction.ASC,"metric"));
    }
}
