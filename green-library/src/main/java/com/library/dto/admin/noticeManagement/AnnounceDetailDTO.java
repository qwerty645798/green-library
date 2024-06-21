package com.library.dto.admin.noticeManagement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AnnounceDetailDTO {
    private int announcementId;
    private String announcementTitle;

    private int adminID;
    private String adminName;

    private String announcementDate;
    private int viewCount;

    private String announcementContent;
    private String announceFile;
}
