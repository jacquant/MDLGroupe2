package be.unamur.mdl_groupe2.root.search;

import be.unamur.mdl_groupe2.root.exception.EmptyResultListException;
import be.unamur.mdl_groupe2.root.models.article.Article;
import be.unamur.mdl_groupe2.root.repositories.ArticleRepository;
import be.unamur.mdl_groupe2.root.repositories.AuthorRepository;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SearchService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public List<Article> Search(Map<String, String> params){
        List<Article> result = null;
        try {
             result = SortResult(FindResult(params));
        } catch (EmptyResultListException e) {
            //TODO
            e.printStackTrace();
        }
        return result;
    }


    /**
     *
     * @param list a list of article to sort
     * @return a sorted list based on the pagerank of each article
     */
    List<Article> SortResult(@NotNull List<Article> list) throws EmptyResultListException {
        if(list.isEmpty()) {
            throw new EmptyResultListException("No Result");
        }else {
            Collections.sort(list);
        }
        return list;
    }

    /**
     *
     * @param params is keyword choice by the user
     * @return list of article that match the keyword
     */
    private List<Article> FindResult(@NotNull Map<String, String> params){
        List<Article> searchRepository = null;

        params.forEach((k, v) -> {

            for(Long id:authorRepository.findAuthorIdWithSurname(v)) {
                searchRepository.addAll(articleRepository.findArticleWriteBy(id));
            }

            searchRepository.addAll(articleRepository.findArticleWithTitle(v));

            searchRepository.addAll(articleRepository.findArticleWithTag(v));
        });
        return searchRepository;
    }

}
