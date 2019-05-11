package be.unamur.mdl_groupe2.root.search;

import be.unamur.mdl_groupe2.root.exception.EmptyResultListException;
import be.unamur.mdl_groupe2.root.models.article.Article;
import be.unamur.mdl_groupe2.root.repositories.ArticleRepository;
import be.unamur.mdl_groupe2.root.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;


public class AdvancedSearchService extends SearchService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private AuthorRepository authorRepository;
    private List<Article> searchRepository;

    public List<Article> AdvancedSearchService(Map<String, String> params) {
        List<Article> result = null;
        try {
            result = SortResult(FindResult(params));
        } catch (EmptyResultListException e) {
            //TODO
            e.printStackTrace();
        }
        return result;
    }


    private List<Article> FindResult(Map<String, String> params){
        params.forEach((k, v) -> {
            switch (k) {
                case "author":
                    for(Long id:authorRepository.findAuthorIdWithSurname(v)) {
                        searchRepository.addAll(articleRepository.findArticleWriteBy(id));
                    }
                    break;
                case "title":
                    searchRepository.addAll(articleRepository.findArticleWithTitle(v));
                    break;
                case "keywords":
                    searchRepository.addAll(articleRepository.findArticleWithTag(v));
                    break;
                default:
                    Map<String,String> tmp = new Hashtable();
                    tmp.put(k,v);
                    //TODO Get back result from search service and add it to searchRepository
                    searchRepository.addAll(SearchService(tmp));
                    break;
            }
        });

        return searchRepository;
    }
}
