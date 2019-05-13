package be.unamur.mdl_groupe2.root.models.author;

import be.unamur.mdl_groupe2.root.models.article.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * The type Author.
 */
@Entity
@Table(name = "Authors")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "contribution", joinColumns = @JoinColumn(name = "article_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
    private Set<Article> articles;

    private String username;

    private String surname;

    private String firstName;

    private String organization;

    private String honorific;

    private String emailContact;

    private String email;
}
