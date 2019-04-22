package be.unamur.mdl_groupe2.root.models.user;

import io.swagger.annotations.*;
import lombok.*;

@Data
public class Login {

    @ApiModelProperty(example = "demo", required = true)
    private String username = "";

    @ApiModelProperty(example = "demo", required = true)
    private String password = "";

}
