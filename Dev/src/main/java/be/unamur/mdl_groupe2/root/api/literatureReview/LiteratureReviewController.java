package be.unamur.mdl_groupe2.root.api.literatureReview;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import be.unamur.mdl_groupe2.root.models.literatureReview.LiteratureReview;
import be.unamur.mdl_groupe2.root.repositories.LiteratureReviewRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "http://localhost:8181", "http://localhost:8080" }, maxAge = 3000)
public class LiteratureReviewController{

    private final LiteratureReviewRepository literatureReviewRepository;

    @Autowired
    public LiteratureReviewController(LiteratureReviewRepository literatureReviewRepository) {
        this.literatureReviewRepository = literatureReviewRepository;
    }

    @PostMapping("/literature_reviews")
    public LiteratureReview create(@RequestBody LiteratureReview literatureReview) {
        return literatureReviewRepository.save(literatureReview);
    }

    @GetMapping("/literature_reviews")
    public List<LiteratureReview> findAll() {
        return literatureReviewRepository.findAll();
    }

    @GetMapping("/literature_reviews/{review_id}")
    public LiteratureReview findByReviewId(@PathVariable("review_id") Long reviewId) {
        return literatureReviewRepository.getOne(reviewId);
    }

    @PutMapping("/literature_reviews/{review_id}")
    public LiteratureReview update(@PathVariable("review_id") Long reviewId, @RequestBody LiteratureReview reviewObject) {
        LiteratureReview literatureReview = literatureReviewRepository.getOne(reviewId);
        literatureReview.setNumberRef(reviewObject.getNumberRef());
        literatureReview.setNumberCriteria(reviewObject.getNumberCriteria());
        literatureReview.setAuthorization(reviewObject.getAuthorization());
        literatureReview.setMatriceref(reviewObject.getMatriceref());
        return literatureReviewRepository.save(literatureReview);
    }

    @DeleteMapping("/literature_reviews/{review_id}")
    public List<LiteratureReview> delete(@PathVariable("review_id") Long reviewId) {
        literatureReviewRepository.deleteById(reviewId);
        return literatureReviewRepository.findAll();
    }
}
