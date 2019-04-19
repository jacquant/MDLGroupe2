package be.unamur.mdl_groupe2.root.models.literatureReview;

import be.unamur.mdl_groupe2.root.models.article.Article;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LiteratureReview extends Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "article", nullable = false)
    private Article article;

    @NonNull
    @NotNull
    private Integer numberRef;

    private Integer numberCriteria;

    private String[] authorization;

    private String[][] matriceref;
}
