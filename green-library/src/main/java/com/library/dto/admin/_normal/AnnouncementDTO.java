package com.library.dto.admin._normal;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class AnnouncementDTO {
    @NotNull
    private int announcementId;
    private String announceTitle;
    @NotNull
    private String writerId;
    private Date writeDate;
    private MultipartFile file;
    private String fileName;
    private String contents;
    private int viewCount;
    private int total_count;
}
