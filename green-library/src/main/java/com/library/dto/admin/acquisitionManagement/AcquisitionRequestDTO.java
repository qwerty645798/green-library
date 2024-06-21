package com.library.dto.admin.acquisitionManagement;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AcquisitionRequestDTO {
    private int requestId;
    private String bookTitle;
    private String authorName;
    private String publisherName;
    private String genreFullName;
    private Date requestDate;
    private String summary;
    private String requestStatus;

}
