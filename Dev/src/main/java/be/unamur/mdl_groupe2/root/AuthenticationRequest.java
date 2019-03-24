package be.unamur.mdl_groupe2.root;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest implements Serializable {
    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
