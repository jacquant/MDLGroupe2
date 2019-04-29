package be.unamur.mdl_groupe2.root.api.synonyme;


import be.unamur.mdl_groupe2.root.synonymes.Synonymes;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SynonymeController {

    @GetMapping("Synonyme")
    public List<String> synonymes(@RequestParam(value="keyword",required = true)String request) throws FileNotFoundException {
        return Synonymes.getSyno(request);
    }
}
