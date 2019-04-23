package be.unamur.mdl_groupe2.root.api.controller;


import be.unamur.mdl_groupe2.root.synonymes.Synonymes;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/QuickSearch/{requete}")
public class SynonymeController {

    @RequestMapping(method = RequestMethod.GET)
    public List<String> getSynonymesAPI(@PathVariable(value="requete") final String pRequete) throws FileNotFoundException {

        return Synonymes.getSyno(pRequete);

    }
}
