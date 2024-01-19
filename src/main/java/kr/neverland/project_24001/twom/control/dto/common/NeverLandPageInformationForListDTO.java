package kr.neverland.project_24001.twom.control.dto.common;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class NeverLandPageInformationForListDTO
{
    private int pageCurrentNumber;
    private int pageSize;
    private int pageMaxNumber;
    private int maxDataCount;
}
