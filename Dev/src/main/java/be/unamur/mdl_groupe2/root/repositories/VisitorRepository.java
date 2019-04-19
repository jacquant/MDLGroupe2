package be.unamur.mdl_groupe2.root.repositories;

import be.unamur.mdl_groupe2.root.models.visitor.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long> {
}
