package be.unamur.mdl_groupe2.root.api.author;

import be.unamur.mdl_groupe2.root.models.author.Author;
import be.unamur.mdl_groupe2.root.repositories.AuthorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorController {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping("/authors")
    public Author create(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @GetMapping("/authors")
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @GetMapping("/authors/{surname}")
    public List<Author> getAuthorBySurname(@PathVariable("surname") String surname) {
        List<Long> list_id = authorRepository.findAuthorIdWithSurname(surname);
        return authorRepository.findAllById(list_id);
    }

    @GetMapping("/authors/{firstName}")
    public List<Author> getAuthorByFirstname(@PathVariable("firstName") String firstName) {
        List<Long> list_id = authorRepository.findAuthorIdWithFirstName(firstName);
        return authorRepository.findAllById(list_id);
    }

    @GetMapping("/authors/{name}")
    public List<Author> getAuthorByName(@PathVariable("name") String name) {
        List<Long> list_id = authorRepository.findAuthorIdWithFirstNameorSurname(name);
        return authorRepository.findAllById(list_id);
    }

    @PutMapping("/authors/{author_id}")
    public Author update(@PathVariable("author_id") Long authorId, @RequestBody Author authorObject) {
        Author author = authorRepository.getOne(authorId);
        author.setFirstName(authorObject.getFirstName());
        author.setSurname(authorObject.getSurname());
        author.setEmail(authorObject.getEmail());
        author.setOrganization(authorObject.getOrganization());
        author.setHonorific(authorObject.getHonorific());
        author.setEmailContact(authorObject.getEmailContact());
        return authorRepository.save(author);
    }

    @DeleteMapping("/authors/{author_id}")
    public List<Author> delete(@PathVariable("author_id") Long authorId) {
        authorRepository.deleteById(authorId);
        return authorRepository.findAll();
    }

    @GetMapping("/authors/{author_id}")
    public Author findByAuthorId(@PathVariable("author_id") Long authorId) {
        return authorRepository.getOne(authorId);
    }
}