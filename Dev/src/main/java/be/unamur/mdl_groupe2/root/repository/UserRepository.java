package be.unamur.mdl_groupe2.root.repository;

import be.unamur.mdl_groupe2.root.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}