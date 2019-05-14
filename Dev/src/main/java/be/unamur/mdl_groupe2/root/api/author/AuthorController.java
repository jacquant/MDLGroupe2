package be.unamur.mdl_groupe2.root.api.author;

import be.unamur.mdl_groupe2.root.models.author.Author;
import be.unamur.mdl_groupe2.root.repositories.AuthorRepository;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Author controller.
 */
@RestController
@RequestMapping("/api")
public class AuthorController {

    private final AuthorRepository authorRepository;

    /**
     * Instantiates a new Author controller.
     *
     * @param authorRepository the author repository
     */
    //@Contract(pure = true)
    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // ===============================
    // GET

    /**
     * Find all list.
     *
     * @return the list
     */
    @GetMapping("/authors")
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    /**
     * Find by author id author.
     *
     * @param authorId the author id
     * @return the author
     */
    @GetMapping("/authors/with_id/{author_id}")
    public Author findByAuthorId(@PathVariable("author_id") Long authorId) {
        return authorRepository.getOne(authorId);
    }

    /**
     * Gets author by surname.
     *
     * @param surname the surname
     * @return the author by surname
     */
    @GetMapping("/authors/with_surname/{surname}")
    public List<Author> getAuthorBySurname(@PathVariable("surname") String surname) {
        List<Long> list_id = authorRepository.findAuthorIdWithSurname(surname);
        return authorRepository.findAllById(list_id);
    }

    /**
     * Gets author by firstname.
     *
     * @param firstName the first name
     * @return the author by firstname
     */
    @GetMapping("/authors/with_firstname/{firstName}")
    public List<Author> getAuthorByFirstname(@PathVariable("firstName") String firstName) {
        List<Long> list_id = authorRepository.findAuthorIdWithFirstName(firstName);
        return authorRepository.findAllById(list_id);
    }

    /**
     * Gets author by name.
     *
     * @param name the name
     * @return the author by name
     */
    @GetMapping("/authors/with_name/{name}")
    public List<Author> getAuthorByName(@PathVariable("name") String name) {
        List<Long> list_id = authorRepository.findAuthorIdWithFirstNameorSurname(name);
        return authorRepository.findAllById(list_id);
    }

    /**
     * @param listID liste de n ID d'autheur
     * @return author list where listID[n]= return.article[n].id
     */
    @GetMapping("article/")
    public List<Author> ListArticleBasedOnID(@PathVariable("authorID")List<Long> listID){
        List<Author> result = null;
        for(int i=0; i<= listID.size();i++){
            result.add(authorRepository.getOne(listID.get(i)));
        }
        return result;
    }

    // ===============================
    // POST

    /**
     * Create author.
     *
     * @param author the author
     * @return the author
     */
    @PostMapping("/authors/new")
    public Author create(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    // ===============================
    // PUT

    /**
     * Update author.
     *
     * @param authorId     the author id
     * @param authorObject the author object
     * @return the author
     */
    @PutMapping("/authors/with_id/{author_id}")
    public Author update(@PathVariable("author_id") Long authorId, @NotNull @RequestBody Author authorObject) {
        Author author = authorRepository.getOne(authorId);
        author.setFirstName(authorObject.getFirstName());
        author.setSurname(authorObject.getSurname());
        author.setEmail(authorObject.getEmail());
        author.setOrganization(authorObject.getOrganization());
        author.setHonorific(authorObject.getHonorific());
        author.setEmailContact(authorObject.getEmailContact());
        return authorRepository.save(author);
    }
    // ===============================
    // DELETE

    /**
     * Delete list.
     *
     * @param authorId the author id
     * @return the list
     */
    @DeleteMapping("/authors/{author_id}")
    public List<Author> delete(@PathVariable("author_id") Long authorId) {
        authorRepository.deleteById(authorId);
        return authorRepository.findAll();
    }
}