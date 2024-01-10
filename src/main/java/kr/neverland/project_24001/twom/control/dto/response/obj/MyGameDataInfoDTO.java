package kr.neverland.project_24001.twom.control.dto.response.obj;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MyGameDataInfoDTO {
    private long myGameDataId;

    private long amount;
    private String unitType;
    private long myGameDataItemId;
    private String gameAllotmentId;
    private String gameAllotmentSelection;
    private long myGameResultId;

    private String resultType;
    private String memo;
    private String details;
    private LocalDateTime reservedDate;
    private boolean useReservedDate;
    private LocalDateTime timeOutDate;
    private boolean useTimeout;

}
