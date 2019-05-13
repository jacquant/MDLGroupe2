package be.unamur.mdl_groupe2.root.api.synonym;


import be.unamur.mdl_groupe2.root.synonymes.Synonyms;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
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
    public List<String> synonyms(@RequestParam(value="keyword")String request) throws FileNotFoundException {
        return Synonyms.getSynonyms(request);
    }
}
