package be.unamur.mdl_groupe2.root.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class LiteratureReview extends Article{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int numberRef;

    private int getNumberRef() {
        return numberRef;
    }

    private int numberCriteria;

    private int getNumberCriteria() {
        return numberCriteria;
    }

    private String [] authorization = {"ModificationAccepted","ModificationAcceptedUnderSupervision","NoModification"};

    private String [][] matriceref = new String [numberRef+1][numberCriteria+1];

    public void setNumberRef(int numberRef) {
        this.numberRef = numberRef;
    }

    public void setNumberCriteria(int numberCriteria) {
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
