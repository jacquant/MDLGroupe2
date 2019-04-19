package be.unamur.mdl_groupe2.root.models.article;

import be.unamur.mdl_groupe2.root.models.articleRef.ArticleRef;
import be.unamur.mdl_groupe2.root.models.literatureReview.LiteratureReview;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Article")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private Set<ArticleRef> bibliography;

    private Boolean authorizedContribution;

    private Boolean contributionUnderSupervision;

    private Long pagerankscore;
}
