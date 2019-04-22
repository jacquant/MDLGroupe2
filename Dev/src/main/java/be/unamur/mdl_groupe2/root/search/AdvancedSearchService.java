package be.unamur.mdl_groupe2.root.search;

import be.unamur.mdl_groupe2.root.repositories.ArticleRepository;
import be.unamur.mdl_groupe2.root.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.Map;


public class AdvancedSearchService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public AdvancedSearchService(Map<String, String> params){


        params.forEach((k, v) -> {
            switch (k) {
                case "author":
                    for(Long id:authorRepository.findAuthorIdWithSurname(v)) {
                        articleRepository.findArticleWriteBy(id);
                    }
                    break;
                case "title":
                    articleRepository.findArticleWithTitle(v);
                    break;
                case "keywords":
                    articleRepository.findArticleWithTag(v);
                    break;
                case "index":
                    //TODO
                    break;
                case "number":
                    //TODO
                    break;
                //TODO other case
                default:
                    new SimpleSearchService(v);
                    break;
            }
        });
    }
}
