package be.unamur.mdl_groupe2.root.models.session;


import lombok.Data;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@Data
public class SessionItem {
    private String token;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private List<String> roles;
}