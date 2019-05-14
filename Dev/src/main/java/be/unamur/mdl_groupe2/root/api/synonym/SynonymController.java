package be.unamur.mdl_groupe2.root.api.synonym;


import be.unamur.mdl_groupe2.root.synonymes.Synonyms;
import org.infinispan.commons.hash.Hash;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The type Synonym controller.
 */
@RestController
@RequestMapping("/api")
public class SynonymController {

    /**
     * Synonyms list.
     *
     * @param request the request
     * @return the list
     * @throws FileNotFoundException the file not found exception
     */
    @GetMapping("Synonym")
    public HashMap<String, List<String>> synonyms(@RequestParam(value="keyword")String request) throws FileNotFoundException {
        List<String> tab = Synonyms.getSynonyms(request);
        HashMap<String, List<String>> hashMap = new HashMap<>();
        hashMap.put("synonym", tab);
        return hashMap;
    }
}
