package be.unamur.mdl_groupe2.root.model;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
/*@Table(name = "literatureReviews")*/
@Data
/*@Builder*/
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

    public Integer getNumberRef() {
        return numberRef;
    }

    public void setNumberRef(Integer numberRef) {
        this.numberRef = numberRef;
    }

    public Integer getNumberCriteria() {
        return numberCriteria;
    }

    public void setNumberCriteria(Integer numberCriteria) {
        this.numberCriteria = numberCriteria;
    }

    public String[] getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String[] authorization) {
        this.authorization = authorization;
    }

    public String[][] getMatriceref() {
        return matriceref;
    }

    public void setMatriceref(String[][] matriceref) {
        this.matriceref = matriceref;
    }
}
