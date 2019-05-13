package be.unamur.mdl_groupe2.root.models.article;

import be.unamur.mdl_groupe2.root.models.articleRef.ArticleRef;
import be.unamur.mdl_groupe2.root.models.literatureReview.LiteratureReview;
import be.unamur.mdl_groupe2.root.models.visualization.Visualization;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Set;

/**
 * The type Article.
 */
@Entity
@Table(name = "Article")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Proxy(lazy = false)
public class Article implements Comparable<Article> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //List of author's id
    private Long[] author;

    private String title;

    private String shortRef;

    private Integer year;

    private String[] countries;

    private String[] domain;

    private String[] tag;

    private Boolean published;

    private String abstractArticle;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<LiteratureReview> literatureReviews;
    //private DBFile pdfFiles;

    private String videoUrl;

    private String ref;

    private String journal;

    private String publisher;

    private String[] targetUsers;

    private String[] dataRealness;

    private String[] dataSource;

    private String[] dataAvailability;

    private String[] interaction;

    private String[] action;

    private int metric;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ArticleRef> bibliography;

    private Boolean open;

    private Boolean authorizedContribution;

    private Boolean contributionUnderSupervision;

    private Long pagerankscore;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Visualization> visualizations;

    @Override
    public int compareTo(Article o) {
        return this.getPagerankscore().compareTo(o.getPagerankscore());
    }
}
