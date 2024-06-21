package com.library.dto.admin._normal;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnnouncementDTO {
    @NotNull
    private int announcementId;
    private String announceTitle;
    @NotNull
    private String writerId;
    private Date writeDate;
    private String fileName;
    private String contents;
    private int viewCount;

}
