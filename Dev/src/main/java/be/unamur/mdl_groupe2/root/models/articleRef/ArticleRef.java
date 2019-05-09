package be.unamur.mdl_groupe2.root.models.articleRef;

import be.unamur.mdl_groupe2.root.models.article.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ArticleRef")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleRef {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "articleId", nullable = false)
    private Article article;
}
