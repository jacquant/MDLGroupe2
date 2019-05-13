package be.unamur.mdl_groupe2.root.models.user;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "Users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userId;

    private String password = "";

    private String company;

    private String firstName;

    private String lastName;

    private String email;

    private int securityProviderId;

    private int defaultCustomerId;

    private String phone;

    private String address1;

    private String address2;

    private String country;

    private String postal;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean isActive;

    private boolean isBlocked;

    private String secretQuestion;

    private String secretAnswer;

    private boolean enableBetaTesting;

    private boolean enableRenewal;

}