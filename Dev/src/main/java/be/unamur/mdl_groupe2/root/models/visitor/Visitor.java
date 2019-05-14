package be.unamur.mdl_groupe2.root.models.visitor;

import javax.persistence.*;

@Entity
@Table(name = "visitor")
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

}
