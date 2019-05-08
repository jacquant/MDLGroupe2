package be.unamur.mdl_groupe2.root.models.article.details;

import be.unamur.mdl_groupe2.root.models.article.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DataRealness")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataRealness {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "article", nullable = false)
    private Article article;

    private String dataRealness;
}
