package be.unamur.mdl_groupe2.root.models.visualization.details;


import be.unamur.mdl_groupe2.root.models.visualization.Visualization;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "MapType")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MapType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String mapType;

    @ManyToOne
    @JoinColumn(name = "visualizationId", nullable = false)
    private Visualization visualization;
}
