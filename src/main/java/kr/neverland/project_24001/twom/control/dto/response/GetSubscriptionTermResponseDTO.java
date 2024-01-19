package kr.neverland.project_24001.twom.control.dto.response;

import kr.neverland.project_24001.twom.control.dto.response.obj.SubscriptionDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class GetSubscriptionTermResponseDTO extends GenericNeverlandResponseDTO.Result {
    private Object request;
    private String isTest="true";

    private SubscriptionDTO subscriptionTerm;
}
