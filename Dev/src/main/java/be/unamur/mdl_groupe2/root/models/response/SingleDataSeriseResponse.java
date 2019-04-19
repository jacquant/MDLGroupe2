package be.unamur.mdl_groupe2.root.models.response;

import lombok.*;

import java.util.*;

import io.swagger.annotations.*;
import be.unamur.mdl_groupe2.root.models.data.*;

@Data
@EqualsAndHashCode(callSuper = false)
public class SingleDataSeriseResponse extends OperationResponse {
    private List<SingleSerise> items;
}