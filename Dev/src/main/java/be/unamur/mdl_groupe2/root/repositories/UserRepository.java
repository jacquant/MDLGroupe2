package be.unamur.mdl_groupe2.root.repositories;

import be.unamur.mdl_groupe2.root.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByUserId(String userId);

    Optional<User> findOneByUserIdAndPassword(String userId, String password);
}