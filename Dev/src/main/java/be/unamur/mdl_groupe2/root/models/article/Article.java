package be.unamur.mdl_groupe2.root.models.article;

import be.unamur.mdl_groupe2.root.models.author.Author;
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
@Proxy(lazy = false)
public class Article implements Comparable<Article> {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "contribution_article", joinColumns = @JoinColumn(name = "article_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
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
    @Column(length = 65536)
    private Long[] bibliographyArticle;
    @Column(length = 65536)
    private Long[] bibliographyLiteratureReview;

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
