package be.unamur.mdl_groupe2.root.models.user;

import be.unamur.mdl_groupe2.root.models.response.OperationResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserResponse extends OperationResponse {
    private User data = new User();
}
