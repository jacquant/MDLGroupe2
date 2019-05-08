package be.unamur.mdl_groupe2.root.models.article;

import be.unamur.mdl_groupe2.root.models.article.details.*;
import be.unamur.mdl_groupe2.root.models.articleRef.ArticleRef;
import be.unamur.mdl_groupe2.root.models.literatureReview.LiteratureReview;
import be.unamur.mdl_groupe2.root.models.visualization.Visualization;
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
public class Article implements Comparable<Article>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //List of author's id
    private Long[] author;

    private String title;

    private String shortRef;

    private Integer year;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private Set<Country> countries;

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

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private Set<TargetUsers> targetUsers;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private Set<DataRealness> dataRealness;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private Set<DataSource> dataSource;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private Set<DataAvailability> dataAvailability;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private Set<Interaction> interaction;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private Set<Action> action;

    private int metric;
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private Set<ArticleRef> bibliography;

    private Boolean open;

    private Boolean authorizedContribution;

    private Boolean contributionUnderSupervision;

    private Long pagerankscore;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private Set<Visualization> visualizations;

    @Override
    public int compareTo(Article o) {
        return this.getPagerankscore().compareTo(o.getPagerankscore());
    }
}
