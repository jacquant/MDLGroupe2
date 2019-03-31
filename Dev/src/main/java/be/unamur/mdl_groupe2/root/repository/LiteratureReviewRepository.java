package be.unamur.mdl_groupe2.root.repository;

import be.unamur.mdl_groupe2.root.model.LiteratureReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiteratureReviewRepository extends JpaRepository<LiteratureReview, Long> {
}
