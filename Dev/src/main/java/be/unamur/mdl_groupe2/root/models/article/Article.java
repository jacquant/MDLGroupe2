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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "contribution_article", joinColumns = @JoinColumn(name = "article_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
    private Set<Author> author;

    private String title;

    private String shortRef;

    private String ref;

    private Integer year;

    private String[] countries;

    private String[] domain;

    private String[] tag;

    private String abstractArticle;

    private Long[] bibliographyArticle;

    private Long[] bibliographyLiteratureReview;

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
