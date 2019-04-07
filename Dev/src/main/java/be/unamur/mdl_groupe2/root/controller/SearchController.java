package be.unamur.mdl_groupe2.root.controller;

import be.unamur.mdl_groupe2.root.model.Article;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final List<Article> searchResult = null;


    public List<Article> searchController(@RequestParam(value="keyword",required = true)String search) {

        //TODO
        return null;
    }
}
