package be.unamur.mdl_groupe2.root.controller;

import be.unamur.mdl_groupe2.root.model.Article;
import be.unamur.mdl_groupe2.root.search.AdvancedSearchService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/AdvSearch")
public class AdvancedSearchController {

    private final List<Article> searchResult = null;


    /* <!-- URL avec deux paramètres nommés 'lang' et 'admin', et ayant pour valeur respectivement 'fr' et 'true' --> /page.jsp?lang=fr&admin=true*/
    public List<Article> AdvancedSearchController(@RequestParam Map<String, String> params) {

        new AdvancedSearchService(params);
        //TODO
        return null;
    }
}
