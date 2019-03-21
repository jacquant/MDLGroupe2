package be.unamur.mdl_groupe2.root.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class LiteratureReview extends Article{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public int numberRef;

    public int getNumberRef() {
        return numberRef;
    }

    public int numberCriteria;

    public int getNumberCriteria() {
        return numberCriteria;
    }

    public String [] authorization = {"ModificationAccepted","ModificationAcceptedUnderSupervision","NoModification"};

    public String [][] matriceref = new String [numberRef+1][numberCriteria+1];
}
