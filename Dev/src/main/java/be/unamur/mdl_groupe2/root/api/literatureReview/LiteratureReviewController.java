package be.unamur.mdl_groupe2.root.api.literatureReview;

import be.unamur.mdl_groupe2.root.models.literatureReview.LiteratureReview;
import be.unamur.mdl_groupe2.root.repositories.LiteratureReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Literature review controller.
 */
@RestController
@RequestMapping("/api")
public class LiteratureReviewController {

    private final LiteratureReviewRepository literatureReviewRepository;

    /**
     * Instantiates a new Literature review controller.
     *
     * @param literatureReviewRepository the literature review repository
     */
    @Autowired
    public LiteratureReviewController(LiteratureReviewRepository literatureReviewRepository) {
        this.literatureReviewRepository = literatureReviewRepository;
    }

    /**
     * Create literature review.
     *
     * @param literatureReview the literature review
     * @return the literature review
     */
    @PostMapping("/literature_reviews")
    public LiteratureReview create(@RequestBody LiteratureReview literatureReview) {
        return literatureReviewRepository.save(literatureReview);
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    @GetMapping("/literature_reviews")
    public List<LiteratureReview> findAll() {
        return literatureReviewRepository.findAll();
    }

    /**
     * Find by review id literature review.
     *
     * @param reviewId the review id
     * @return the literature review
     */
    @GetMapping("/literature_reviews/{review_id}")
    public LiteratureReview findByReviewId(@PathVariable("review_id") Long reviewId) {
        return literatureReviewRepository.getOne(reviewId);
    }

    /**
     * Update literature review.
     *
     * @param reviewId     the review id
     * @param reviewObject the review object
     * @return the literature review
     */
    @PutMapping("/literature_reviews/{review_id}")
    public LiteratureReview update(@PathVariable("review_id") Long reviewId, @RequestBody LiteratureReview reviewObject) {
        LiteratureReview literatureReview = literatureReviewRepository.getOne(reviewId);
        literatureReview.setNumberCriteria(reviewObject.getNumberCriteria());
        literatureReview.setAuthorization(reviewObject.getAuthorization());
        literatureReview.setMatriceref(reviewObject.getMatriceref());
        return literatureReviewRepository.save(literatureReview);
    }

    /**
     * Delete list.
     *
     * @param reviewId the review id
     * @return the list
     */
    @DeleteMapping("/literature_reviews/{review_id}")
    public List<LiteratureReview> delete(@PathVariable("review_id") Long reviewId) {
        literatureReviewRepository.deleteById(reviewId);
        return literatureReviewRepository.findAll();
    }
}
