package be.unamur.mdl_groupe2.root.repositories;

import be.unamur.mdl_groupe2.root.models.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    //TODO protect against SQL injection
    @Query(value = "SELECT id FROM Author u WHERE u.surname=?1")
    List<Long> findAuthorIdWithSurname(String surname);

    //TODO protect against SQL injection
    @Query(value = "SELECT id FROM Author u WHERE u.firstName=?1")
    List<Long> findAuthorIdWithFirstName(String surname);

    //TODO protect against SQL injection
    @Query(value = "SELECT id FROM Author u WHERE u.firstName=?1 OR u.surname=?1")
    List<Long> findAuthorIdWithFirstNameorSurname(String surname);

}

