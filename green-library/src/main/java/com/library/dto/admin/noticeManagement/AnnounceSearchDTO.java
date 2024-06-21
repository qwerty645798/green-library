package com.library.dto.admin.noticeManagement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AnnounceSearchDTO {
    private int announcementId;
    private String announcementTitle;
    private String announcementContent;
    private int adminID;
    private String adminName;
    private String announcementDate;
    private String announceFile;
    private String keyword;

}
