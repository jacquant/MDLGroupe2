package be.unamur.mdl_groupe2.root.models.visualization;

import be.unamur.mdl_groupe2.root.models.article.Article;
import be.unamur.mdl_groupe2.root.models.visualization.details.*;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Visualization")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Visualization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "article", nullable = false)
    private Article article;

    @OneToMany(mappedBy = "visualization", cascade = CascadeType.ALL)
    private Set<DataDimension> dataDimensions;

    @OneToMany(mappedBy = "visualization", cascade = CascadeType.ALL)
    private Set<DataType> dataTypes;

    @OneToMany(mappedBy = "visualization", cascade = CascadeType.ALL)
    private Set<VisTechnique> visTechniques;

    @OneToMany(mappedBy = "visualization", cascade = CascadeType.ALL)
    private Set<MapType> mapTypes;

    @OneToMany(mappedBy = "visualization", cascade = CascadeType.ALL)
    private Set<VisAttributes> visAttributes;
}
