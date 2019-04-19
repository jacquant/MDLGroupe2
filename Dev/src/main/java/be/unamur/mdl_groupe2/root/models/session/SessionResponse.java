package be.unamur.mdl_groupe2.root.models.session;

import io.swagger.annotations.*;
import lombok.*;

import java.util.*;

import be.unamur.mdl_groupe2.root.models.response.*;

@Data
@EqualsAndHashCode(callSuper = false)
public class SessionResponse extends OperationResponse {
    @ApiModelProperty(required = true, value = "")
    private SessionItem item;
}
