package be.unamur.mdl_groupe2.root.api.search;

import java.util.List;

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
    public List<Article> searchController(@RequestParam(value="keyword",required = true)String search) {

        //TODO
        return null;
    }

    @GetMapping("QuickSearchJson")
    public JSONArray searchControllerJson(@RequestParam(value="keyword",required = true)String search){
        return new JSONArray(new Gson().toJson(searchController(search)));
    }
}
