package kr.neverland.project_24001.twom.control.dto.response.obj;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubscriptionDTO {
    //이용 약관 내용 termcode=0x01
    //개인정보 수집 어쩌고 termcode=0x02

    private String registedDataTime;
    private String contents;
    private String termcode;
}
