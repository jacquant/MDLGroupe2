package be.unamur.mdl_groupe2.root.search;

import be.unamur.mdl_groupe2.root.exception.EmptyResultListException;
import be.unamur.mdl_groupe2.root.models.article.Article;
import be.unamur.mdl_groupe2.root.repositories.ArticleRepository;
import be.unamur.mdl_groupe2.root.repositories.AuthorRepository;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AdvancedSearchService extends SearchService {

    private final ArticleRepository articleRepository;
    private final AuthorRepository authorRepository;
    private List<Article> searchRepository;

    public AdvancedSearchService(ArticleRepository articleRepository, AuthorRepository authorRepository) {
        this.articleRepository = articleRepository;
        this.authorRepository = authorRepository;
    }

    public List<Long> AdvancedSearch(Map<String, String> params) {
        List<Long> result = new ArrayList<>(Arrays.asList(1L, 2L));
        try {
            result = SortResult(FindResult(params));
        } catch (EmptyResultListException e) {
            //TODO
            e.printStackTrace();
        }
        return result;
    }


    private List<Long> FindResult(Map<String, String> params) {
        List<Long> searchId = new ArrayList<>(Arrays.asList(1L, 2L));
        params.forEach((k, v) -> {
            if (k.equals("author")) {
                for (Long id : authorRepository.findAuthorIdWithSurname(v)) {
                    for (Article article : articleRepository.findArticleWriteBy(id)) {
                        searchId.add(article.getId());
                    }
                }
            } else if (k.equals("title")) {
                for (Article article : articleRepository.findArticleWithTitle(v)) {
                    searchId.add(article.getId());
                }
            } else if (k.equals("keywords")){
                for (Article article : articleRepository.findArticleWithTag(v)) {
                    searchId.add(article.getId());
                }
            } else{
                searchId.addAll(Search(v));
            }
        });

        return new ArrayList<>(new HashSet<>(searchId));
    }
}
