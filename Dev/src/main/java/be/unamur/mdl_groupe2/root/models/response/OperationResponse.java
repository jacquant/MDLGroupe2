package be.unamur.mdl_groupe2.root.models.response;

import io.swagger.annotations.*;
import lombok.*;

@Data //for getters and setters
public class OperationResponse {
    public enum ResponseStatusEnum {SUCCESS, ERROR, WARNING, NO_ACCESS}

    ;
    @ApiModelProperty(required = true)
    private ResponseStatusEnum operationStatus;
    private String operationMessage;
}