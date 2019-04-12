package be.unamur.mdl_groupe2.root.search;

import be.unamur.mdl_groupe2.root.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;


public class AdvancedSearchService {

    @Autowired
    private final ArticleRepository searchRepository=null ;

    public AdvancedSearchService(Map<String, String> params){


        params.forEach((k, v) -> {
            switch (k) {
                case "author":
                    //TODO
                    break;
                case "title":
                    //TODO
                    break;
                case "keywords":
                    //TODO
                    break;
                case "index":
                    //TODO
                    break;
                case "number":
                    //TODO
                    break;
                //TODO other case
                default:
                    new SimpleSearchService(v);
                    break;
            }
        });
    }
}
