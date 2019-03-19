package be.unamur.mdl_groupe2.root.model;

import javax.persistence.*;

@Entity
@Table(name = "author")
public class Author extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
