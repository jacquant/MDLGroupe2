package be.unamur.mdl_groupe2.root.models.author;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Authors")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Author{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String surname;

    private String firstName;

    private String email;

    private String organization;

    private String honorific;

    private String emailContact;
}
