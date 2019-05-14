package be.unamur.mdl_groupe2.root.api.search;

import java.util.List;
import java.util.Map;

import be.unamur.mdl_groupe2.root.models.article.Article;
import be.unamur.mdl_groupe2.root.repositories.ArticleRepository;
import be.unamur.mdl_groupe2.root.repositories.AuthorRepository;
import be.unamur.mdl_groupe2.root.search.AdvancedSearchService;
import be.unamur.mdl_groupe2.root.search.SearchService;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.springframework.web.bind.annotation.*;

/**
 * The type Search controller.
 */
@RestController
@RequestMapping("/api")
public class SearchController {

    private final ArticleRepository articleRepository;
    private final AuthorRepository authorRepository;

    /**
     * Instantiates a new Search controller.
     *
     * @param articleRepository the article repository
     * @param authorRepository  the author repository
     */
    public SearchController(ArticleRepository articleRepository, AuthorRepository authorRepository) {
        this.articleRepository = articleRepository;
        this.authorRepository = authorRepository;
    }


    /**
     * Search controller list.
     *
     * @param params the params
     * @return the list
     */
    @GetMapping("/QuickSearch")
    public List<Article> searchController(@RequestParam String params) {
        return new SearchService(authorRepository, articleRepository).Search(params);
    }

    /**
     * Advanced search controller list.
     *
     * @param params the params
     * @return the list
     */

    @GetMapping("/AdvancedSearch")
    public List<Article> AdvancedSearchController(@RequestParam Map<String, String> params) {
        return new AdvancedSearchService(articleRepository, authorRepository).AdvancedSearch(params);
    }

}
