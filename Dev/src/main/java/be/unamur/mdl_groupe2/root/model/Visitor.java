package be.unamur.mdl_groupe2.root.model;

import javax.persistence.*;

@Entity
@Table(name = "visitor")
public class Visitor extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
