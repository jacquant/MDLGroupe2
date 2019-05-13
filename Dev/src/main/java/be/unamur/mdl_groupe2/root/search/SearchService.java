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

    public List<Article> Search(String params){
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
    private List<Article> FindResult(@NotNull String params){
        List<Article> searchRepository = null;
        String [] split = params.split(" ");

        for (int i=0; i<=split.length; i++){

            for(Long id:authorRepository.findAuthorIdWithSurname(split[i])) {
                searchRepository.addAll(articleRepository.findArticleWriteBy(id));
            }

            searchRepository.addAll(articleRepository.findArticleWithTitle(split[i]));

            searchRepository.addAll(articleRepository.findArticleWithTag(split[i]));
        };
        return searchRepository;
    }

}
