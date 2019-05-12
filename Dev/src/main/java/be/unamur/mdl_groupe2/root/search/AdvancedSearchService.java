package be.unamur.mdl_groupe2.root.search;

import be.unamur.mdl_groupe2.root.exception.EmptyResultListException;
import be.unamur.mdl_groupe2.root.models.article.Article;
import be.unamur.mdl_groupe2.root.repositories.ArticleRepository;
import be.unamur.mdl_groupe2.root.repositories.AuthorRepository;
import org.springframework.stereotype.Component;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Component
public class AdvancedSearchService extends SearchService {

    private final ArticleRepository articleRepository;
    private final AuthorRepository authorRepository;
    private List<Article> searchRepository;

    public AdvancedSearchService(ArticleRepository articleRepository, AuthorRepository authorRepository) {
        this.articleRepository = articleRepository;
        this.authorRepository = authorRepository;
    }

    public List<Article> AdvancedSearch(Map<String, String> params) {
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
                    searchRepository.addAll(Search(tmp));
                    break;
            }
        });

        return searchRepository;
    }
}
