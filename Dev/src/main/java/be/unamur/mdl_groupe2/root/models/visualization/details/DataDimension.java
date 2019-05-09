package be.unamur.mdl_groupe2.root.models.visualization.details;

import be.unamur.mdl_groupe2.root.models.visualization.Visualization;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DataDimension")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataDimension {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String dataDimension;

    @ManyToOne
    @JoinColumn(name = "veisualizationId", nullable = false)
    private Visualization visualization;
}
