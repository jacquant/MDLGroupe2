package be.unamur.mdl_groupe2.root.api.synonyme;


import be.unamur.mdl_groupe2.root.synonymes.Synonymes;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "http://localhost:8181", "http://localhost:8080" }, maxAge = 3000)
public class SynonymeController {

    @GetMapping("Synonyme")
    public List<String> synonymes(@RequestParam(value="keyword")String request) throws FileNotFoundException {
        return Synonymes.getSyno(request);
    }
}
