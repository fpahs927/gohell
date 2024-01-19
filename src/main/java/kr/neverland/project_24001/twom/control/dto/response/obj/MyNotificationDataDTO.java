package kr.neverland.project_24001.twom.control.dto.response.obj;

import lombok.Getter;

@Getter
public class MyNotificationDataDTO {
    private String notificationTarget;
    private long registedNotificationDate;
    private String notificationMessageType;
    private String notificationMessageDetails;
    private String notificationAction;
}
