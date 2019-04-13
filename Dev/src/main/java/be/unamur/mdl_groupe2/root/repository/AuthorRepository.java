package be.unamur.mdl_groupe2.root.repository;

import be.unamur.mdl_groupe2.root.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query(value = "SELECT u FROM authors u WHERE u.surname=?1")
    List<Author> findAuthorId(String surname);
}
