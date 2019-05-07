package be.unamur.mdl_groupe2.root.models.session;

import be.unamur.mdl_groupe2.root.models.response.OperationResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SessionResponse extends OperationResponse {
    @ApiModelProperty(required = true, value = "")
    private SessionItem item;
}
