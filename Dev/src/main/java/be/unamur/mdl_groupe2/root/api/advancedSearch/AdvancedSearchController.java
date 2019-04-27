package be.unamur.mdl_groupe2.root.api.advancedSearch;

import be.unamur.mdl_groupe2.root.models.article.Article;
import be.unamur.mdl_groupe2.root.search.AdvancedSearchService;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AdvancedSearchController {

    private final List<Article> searchResult = null;


    /* <!-- URL avec deux paramètres nommés 'lang' et 'admin', et ayant pour valeur respectivement 'fr' et 'true' --> /page.jsp?lang=fr&admin=true*/
    @GetMapping("AdvancedSearch")
    public List<Article> AdvancedSearchController(@RequestParam Map<String, String> params) {

        new AdvancedSearchService(params);
        //TODO
        return null;
    }

    @GetMapping("AdvancedSearchJson")
    public JSONArray AdvancedSearchControllerJson(@RequestParam Map<String, String> params){

        return new JSONArray(new Gson().toJson(AdvancedSearchController(params)));
    }
}
