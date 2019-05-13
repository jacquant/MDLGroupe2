package be.unamur.mdl_groupe2.root.models.literatureReview;

import be.unamur.mdl_groupe2.root.models.article.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * The type Literature review.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Proxy(lazy = false)
public class LiteratureReview extends Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "articleId")
    private Article article;

    @NonNull
    @NotNull
    private Integer numberRef;

    private Integer numberCriteria;

    private String[] authorization;

    private String[][] matriceref;
}
