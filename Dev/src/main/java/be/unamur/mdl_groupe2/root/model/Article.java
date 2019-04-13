package be.unamur.mdl_groupe2.root.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "article")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //List of author's id
    private Long[] author;

    private String title;

    private String[] domain;

    private String[] tag;

    private Boolean published;

    private String abstractArticle;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private Set<LiteratureReview> literatureReviews;
    // private DBFile pdfFiles;

    private String videoUrl;

    private String ref;

    private String journal;

    private String publisher;

    private int metric;

    private String[] bibliography;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String[] getBibliography() {
        return bibliography;
    }

    public void setBibliography(String[] bibliography) {
        this.bibliography = bibliography;
    }

    public int getMetric() {
        return metric;
    }

    public void setMetric(int metric) {
        this.metric = metric;
    }

    public Long[] getAuthor() {

        return author;
    }

    public void setAuthor(Long[] author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getDomain() {
        return domain;
    }

    public void setDomain(String[] domain) {
        this.domain = domain;
    }

    public String[] getTag() {
        return tag;
    }

    public void setTag(String[] domaine) {
        this.tag = tag;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public String getAbstractArticle() {
        return abstractArticle;
    }

    public void setAbstractArticle(String abstractArticle) {
        this.abstractArticle = abstractArticle;
    }

    /*
        public DBFile getPdfFiles() {
            return pdfFiles;
        }

        public void setPdfFiles(DBFile pdfFiles) {
            this.pdfFiles = pdfFiles;
        }
    */
    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
