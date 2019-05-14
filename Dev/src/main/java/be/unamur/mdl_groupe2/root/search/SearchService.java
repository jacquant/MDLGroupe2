package be.unamur.mdl_groupe2.root.search;

import be.unamur.mdl_groupe2.root.exception.EmptyResultListException;
import be.unamur.mdl_groupe2.root.models.article.Article;
import be.unamur.mdl_groupe2.root.repositories.ArticleRepository;
import be.unamur.mdl_groupe2.root.repositories.AuthorRepository;
import org.checkerframework.checker.units.qual.A;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class SearchService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public List<Long> Search(String params) {
        List<Long> result;
        try {
            result = SortResult(FindResult(params));
        } catch (EmptyResultListException e) {
            e.printStackTrace();
        }
        result = FindResult(params);
        return result;
    }


    /**
     * @param list a list of article to sort
     * @return a sorted list based on the pagerank of each article
     */
    List<Long> SortResult(@NotNull List<Long> list) throws EmptyResultListException {
        if (list.isEmpty()) {
            throw new EmptyResultListException("No Result");
        } else {
            Collections.sort(list);
        }
        return list;
    }

    /**
     * @param params is keyword choice by the user
     * @return list of article that match the keyword
     */
    private List<Long> FindResult(@NotNull String params) {
        List<Long> searchId = new ArrayList<>(Arrays.asList(1L, 2L));
        String[] split = params.split(" ");
        System.out.println(params);

        for (int i = 0; i <= split.length; i++) {
            System.out.println(split[i]);
            System.out.println(safeId(authorRepository.findAuthorIdWithSurname(split[i])));
            for (Long id : (safeId(authorRepository.findAuthorIdWithSurname(split[i])))) {
                for (Article article : safeArticle(articleRepository.findArticleWriteBy(id))) {
                    searchId.add(article.getId());
                }
            }
            for (Long id : safeId(authorRepository.findAuthorIdWithFirstName(split[i]))) {
                for (Article article : safeArticle(articleRepository.findArticleWriteBy(id))) {
                    searchId.add(article.getId());
                }
            }
            for (Article article : safeArticle(articleRepository.findArticleWithTag(split[i]))) {
                searchId.add(article.getId());
            }
            for (Article article : safeArticle(articleRepository.findArticleWithTitle(split[i]))) {
                searchId.add(article.getId());
            }
        }
        return new ArrayList<>(
                new HashSet<>(searchId));
    }
    private static List<Long> safeId( List<Long> other ) {
        return other == null ? Collections.emptyList() : other;
    }

    private static List<Article> safeArticle( List<Article> other ) {
        return other == null ? Collections.emptyList() : other;
    }
}
