package be.unamur.mdl_groupe2.root.api.search;

import be.unamur.mdl_groupe2.root.models.article.Article;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SearchController {

    private final List<Article> searchResult = null;

    @GetMapping("QuickSearch")
    public List<Article> searchController(@RequestParam(value="keyword",required = true)String search) {

        //TODO
        return null;
    }
}
