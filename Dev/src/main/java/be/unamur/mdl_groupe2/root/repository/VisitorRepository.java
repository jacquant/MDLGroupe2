package be.unamur.mdl_groupe2.root.repository;

import be.unamur.mdl_groupe2.root.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<User, Long> {
}