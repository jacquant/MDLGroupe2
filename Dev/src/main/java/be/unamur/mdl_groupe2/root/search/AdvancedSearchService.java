package be.unamur.mdl_groupe2.root.search;

import be.unamur.mdl_groupe2.root.exception.EmptyResultListException;
import be.unamur.mdl_groupe2.root.models.article.Article;
import be.unamur.mdl_groupe2.root.models.author.Author;
import be.unamur.mdl_groupe2.root.repositories.ArticleRepository;
import be.unamur.mdl_groupe2.root.repositories.AuthorRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

import static java.util.Collections.emptyList;

public class AdvancedSearchService {

    private final ArticleRepository articleRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public AdvancedSearchService(ArticleRepository articleRepository, AuthorRepository authorRepository) {
        this.articleRepository = articleRepository;
        this.authorRepository = authorRepository;
    }

    public List<Article> AdvancedSearch(Map<String, String> params) {
        List<Long> result;
        result = FindResult(params);
        try {
            return SortResult(articleRepository.findAllById(result));
        } catch (EmptyResultListException e) {
            return emptyList();
        }
    }

    /**
     * @param list a list of article to sort
     * @return a sorted list based on the pagerank of each article
     */
    public List<Article> SortResult(@NotNull List<Article> list) throws EmptyResultListException {
        if (list.isEmpty()) {
            throw new EmptyResultListException("No Result");
        } else {
            Collections.sort(list);
        }
        return list;
    }


    private List<Long> FindResult(Map<String, String> params) {
        List<Long> searchId = new ArrayList<>(Arrays.asList(1L, 2L));
        params.forEach((k, v) -> {
            switch(k){
                case "author":
                    if (v.isEmpty())emptyList();
                    String[] splitAuthor = v.split(" ");
                    for (int i = 0; i < splitAuthor.length; i++) {
                        for (Author author : (safeAuthor(authorRepository.findAuthorsBySurnameContains(splitAuthor[i])))) {
                            for (Article article : safeArticle(articleRepository.findArticlesByAuthor(author))) {
                                searchId.add(article.getId());
                            }
                        }
                    }
                    break;
                case "notauthor":
                    if (v.isEmpty())emptyList();
                    String[] splitnoAuthor = v.split(" ");
                    for (int i = 0; i < splitnoAuthor.length; i++) {
                        for (Author author : (safeAuthor(authorRepository.findAuthorsBySurnameContains(splitnoAuthor[i])))) {
                            for (Article article : safeArticle(articleRepository.findArticlesByAuthor(author))) {
                                searchId.remove(article.getId());
                            }
                        }
                    }

                    break;
                case "title":
                    if (v.isEmpty())emptyList();
                    String[] splitTitle = v.split(" ");
                    for (int i = 0; i < splitTitle.length; i++) {
                        for(Article article : safeArticle(articleRepository.findArticleWithTitle(splitTitle[i]))){
                            searchId.add(article.getId());
                        }
                    }
                    break;
                case "nottitle":
                    if (v.isEmpty())emptyList();
                    String[] splitnoTitle = v.split(" ");
                    for (int i = 0; i < splitnoTitle.length; i++) {
                        for(Article article : safeArticle(articleRepository.findArticleWithTitle(splitnoTitle[i]))){
                            searchId.remove(article.getId());
                        }
                    }
                    break;
                case "domaine":
                    if (v.isEmpty())emptyList();
                    String[] splitDomain = v.split(" ");
                    for (int i = 0; i < splitDomain.length; i++) {
                        for(Article article: safeArticle(articleRepository.findArticleByDomainIn(splitDomain[i]))){
                            searchId.add(article.getId());
                        }

                    }
                    break;
                case "nodomaine":
                    if (v.isEmpty())emptyList();
                    String[] splitnodomain = v.split(" ");
                    for (int i = 0; i < splitnodomain.length; i++) {
                        for(Article article: safeArticle(articleRepository.findArticleByDomainIn(splitnodomain[i]))){
                            searchId.remove(article.getId());
                        }
                    }
                    break;
                default:
                    if (v.isEmpty())emptyList();
            }

        });

        return new ArrayList<>(new HashSet<>(searchId));
    }

    private static List<Article> safeArticle( List<Article> other ) {
        return other == null ? emptyList() : other;
    }

    private static List<Author> safeAuthor( List<Author> other ) {
        return other == null ? emptyList() : other;
    }
}