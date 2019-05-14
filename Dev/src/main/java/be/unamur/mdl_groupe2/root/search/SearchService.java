package be.unamur.mdl_groupe2.root.search;

import be.unamur.mdl_groupe2.root.exception.EmptyResultListException;
import be.unamur.mdl_groupe2.root.models.article.Article;
import be.unamur.mdl_groupe2.root.models.author.Author;
import be.unamur.mdl_groupe2.root.repositories.ArticleRepository;
import be.unamur.mdl_groupe2.root.repositories.AuthorRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import be.unamur.mdl_groupe2.root.synonymes.Synonyms;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.*;
import java.util.List;

import static java.util.Collections.emptyList;

@Component
public class SearchService {

    private final ArticleRepository articleRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public SearchService(AuthorRepository authorRepository, ArticleRepository articleRepository) {
        this.authorRepository = authorRepository;
        this.articleRepository = articleRepository;
    }


    public List<Article> Search(String params) {
        List<Long> result;
        result = FindResult(params);
        try {
            return SortResult(articleRepository.findAllById(result));
        } catch (EmptyResultListException e) {
            return Collections.emptyList();
        }
    }


    /**
     * @param list a list of article to sort
     * @return a sorted list based on the pagerank of each article
     */
    private List<Article> SortResult(@NotNull List<Article> list) throws EmptyResultListException {
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
        List<Long> searchId = new ArrayList<>(Arrays.asList());
        if (params.isEmpty()) return emptyList();
        else {
            String[] split = params.split(" ");

            for (int i = 0; i < split.length; i++) {
                for (Author author : (safeAuthor(authorRepository.findAuthorsBySurnameContains(split[i])))) {
                    for (Article article : safeArticle(articleRepository.findArticlesByAuthor(author))) {
                        searchId.add(article.getId());
                    }
                }
                for (Author author : safeAuthor(authorRepository.findAuthorsByFirstNameContains(split[i]))) {
                    for (Article article : safeArticle(articleRepository.findArticlesByAuthor(author))) {
                        searchId.add(article.getId());
                    }
                }
    /*            for (Article article : safeArticle(articleRepository.findArticlesByTagContains(split[i].split("")))) {
                    searchId.add(article.getId());
                }*/
                for (Article article : safeArticle(articleRepository.findArticlesByTitleContains(split[i]))) {
                    searchId.add(article.getId());
                }
            }
            return new ArrayList<>(
                    new HashSet<>(searchId));
        }
    }
    private static List<Long> safeId( List<Long> other ) {
        return other == null ? Collections.emptyList() : other;
    }

    private static List<Article> safeArticle( List<Article> other ) {
        return other == null ? Collections.emptyList() : other;
    }

    private static List<Author> safeAuthor( List<Author> other ) {
        return other == null ? Collections.emptyList() : other;
    }
}
