package be.unamur.mdl_groupe2.root.models.literatureReview;

import be.unamur.mdl_groupe2.root.models.author.Author;
import be.unamur.mdl_groupe2.root.models.visualization.Visualization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Set;

/**
 * The type Literature review.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Proxy(lazy = false)
public class LiteratureReview implements Comparable<LiteratureReview> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "contribution_literature_review",
               joinColumns = @JoinColumn(name = "literature_review_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
    private Set<Author> author;

    private String title;

    private String shortRef;

    private String ref;

    private Integer year;

    private String[] countries;

    private String[] domain;

    private String[] tag;

    private String abstractArticle;

    private String videoUrl;

    private String journal;

    private String publisher;

    private Boolean published;

    private String[] targetUsers;

    private String[] dataRealness;

    private String[] dataSource;

    private String[] dataAvailability;

    private String[] interaction;

    private String[] action;

    private int metric;

    private Long[] bibliographyArticle;

    private Long[] bibliographyLiteratureReview;

    private Boolean open;

    private Boolean authorizedContribution;

    private Boolean contributionUnderSupervision;

    private Long pagerankscore;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Visualization> visualizations;

    private Integer numberCriteria;

    private String[] authorization;

    private String[][] matriceref;

    @Override
    public int compareTo(LiteratureReview o) {
        return this.getPagerankscore().compareTo(o.getPagerankscore());
    }
}
