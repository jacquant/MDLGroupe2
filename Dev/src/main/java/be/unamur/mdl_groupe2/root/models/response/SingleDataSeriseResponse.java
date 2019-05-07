package be.unamur.mdl_groupe2.root.models.response;

import java.util.List;

import be.unamur.mdl_groupe2.root.models.data.SingleSerise;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SingleDataSeriseResponse extends OperationResponse {
    private List<SingleSerise> items;
}