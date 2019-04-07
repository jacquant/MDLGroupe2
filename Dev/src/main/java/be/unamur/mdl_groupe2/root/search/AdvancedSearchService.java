package be.unamur.mdl_groupe2.root.search;

import java.util.Map;


public class AdvancedSearchService {

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
                //TODO other case
                default:
                    new SimpleSearchService(v);
                    break;
            }
        });
    }
}
