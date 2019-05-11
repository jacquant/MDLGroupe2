package be.unamur.mdl_groupe2.root.api.search;

import java.util.List;
import java.util.Map;

import be.unamur.mdl_groupe2.root.search.AdvancedSearchService;
import be.unamur.mdl_groupe2.root.search.SearchService;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import be.unamur.mdl_groupe2.root.models.article.Article;

@RestController
@RequestMapping("/api")
public class SearchController {

    private final List<Article> searchResult = null;

    @GetMapping("QuickSearch")
    public List<Article> searchController(@RequestParam Map<String, String> params) {

        return new SearchService().SearchService(params);
    }

    @GetMapping("QuickSearchJson")
    public JSONArray searchControllerJson(@RequestParam Map<String, String> params){
        return new JSONArray(new Gson().toJson(searchController(params)));
    }


    /* <!-- URL avec deux paramètres nommés 'lang' et 'admin', et ayant pour valeur respectivement 'fr' et 'true' --> /page.jsp?lang=fr&admin=true*/
    @GetMapping("AdvancedSearch")
    public List<Article> AdvancedSearchController(@RequestParam Map<String, String> params) {

        return new AdvancedSearchService().AdvancedSearchService(params);
    }

    @GetMapping("AdvancedSearchJson")
    public JSONArray AdvancedSearchControllerJson(@RequestParam Map<String, String> params){

        return new JSONArray(new Gson().toJson(AdvancedSearchController(params)));
    }
}
