package be.unamur.mdl_groupe2.root.models.visualization.details;


import be.unamur.mdl_groupe2.root.models.visualization.Visualization;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "VisAttributes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VisAttributes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String visAttribute;

    @ManyToOne
    @JoinColumn(name = "visualization", nullable = false)
    private Visualization visualization;
}
