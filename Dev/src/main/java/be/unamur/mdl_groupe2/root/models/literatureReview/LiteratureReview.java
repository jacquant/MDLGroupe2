package be.unamur.mdl_groupe2.root.models.literatureReview;

import be.unamur.mdl_groupe2.root.models.author.Author;
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
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "contribution_literature_review",
               joinColumns = @JoinColumn(name = "literature_review_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
    private Set<Author> author;
    @Column(length = 65536)
    private String title;

    private String shortRef;

    private String ref;

    private Integer year;
    @Column(length = 65536)
    private String[] countries;
    @Column(length = 65536)
    private String[] domain;
    @Column(length = 65536)
    private String[] tag;
    @Column(length = 65536)
    private String abstractArticle;

    private String videoUrl;

    private String journal;

    private String publisher;

    private Boolean published;
    @Column(length = 65536)
    private String[] targetUsers;
    @Column(length = 65536)
    private String[] dataRealness;
    @Column(length = 65536)
    private String[] dataSource;
    @Column(length = 65536)
    private String[] dataAvailability;
    @Column(length = 65536)
    private String[] interaction;
    @Column(length = 65536)
    private String[] action;

    private int metric;
    @Column(length = 65536)
    private Long[] bibliographyArticle;
    @Column(length = 65536)
    private Long[] bibliographyLiteratureReview;

    private Boolean open;

    private Boolean authorizedContribution;

    private Boolean contributionUnderSupervision;

    private Long pagerankscore;

    @Column(length = 65536)
    private String[] visu_datadimension;

    @Column(length = 65536)
    private String[] visu_StringdataType;

    @Column(length = 65536)
    private String[] visu_mapType;

    @Column(length = 65536)
    private String[] visu_visAttribute;

    @Column(length = 65536)
    private String[] visu_visTechnique;

    private Integer numberCriteria;
    @Column(length = 65536)
    private String[] authorization;
    @Column(length = 65536)
    private String[][] matriceref;

    @Override
    public int compareTo(LiteratureReview o) {
        return this.getPagerankscore().compareTo(o.getPagerankscore());
    }
}
