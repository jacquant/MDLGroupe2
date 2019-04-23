package be.unamur.mdl_groupe2.root.repositories;

import be.unamur.mdl_groupe2.root.models.literatureReview.LiteratureReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiteratureReviewRepository extends JpaRepository<LiteratureReview, Long> {
}