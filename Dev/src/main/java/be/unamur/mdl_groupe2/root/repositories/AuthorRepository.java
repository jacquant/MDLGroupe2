package be.unamur.mdl_groupe2.root.repositories;

import be.unamur.mdl_groupe2.root.models.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Author repository.
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    /**
     * Find author id with surname list.
     *
     * @param surname the surname
     * @return the list
     */
//TODO protect against SQL injection
    @Query(value = "SELECT id FROM Author u WHERE u.surname=?1")
    List<Long> findAuthorIdWithSurname(String surname);

    /**
     * Find author id with first name list.
     *
     * @param surname the surname
     * @return the list
     */
//TODO protect against SQL injection
    @Query(value = "SELECT id FROM Author u WHERE u.firstName=?1")
    List<Long> findAuthorIdWithFirstName(String surname);

    /**
     * Find author id with first nameor surname list.
     *
     * @param surname the surname
     * @return the list
     */
//TODO protect against SQL injection
    @Query(value = "SELECT id FROM Author u WHERE u.firstName=?1 OR u.surname=?1")
    List<Long> findAuthorIdWithFirstNameorSurname(String surname);

}

