package be.unamur.mdl_groupe2.root.models.visualization.details;

import be.unamur.mdl_groupe2.root.models.visualization.Visualization;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DataType")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class DataType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String dataType;

    @ManyToOne
    @JoinColumn(name = "visualization", nullable = false)
    private Visualization visualization;
}
