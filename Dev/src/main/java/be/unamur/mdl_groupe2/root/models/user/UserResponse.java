package be.unamur.mdl_groupe2.root.models.user;

import io.swagger.annotations.*;
import lombok.*;

import java.util.*;

import be.unamur.mdl_groupe2.root.models.response.*;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserResponse extends OperationResponse {
    private User data = new User();
}
