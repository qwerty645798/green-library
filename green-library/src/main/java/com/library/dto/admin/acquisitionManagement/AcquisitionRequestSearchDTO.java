package com.library.dto.admin.acquisitionManagement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class AcquisitionRequestSearchDTO {

    private int requestId;
    private String requestTitle;
    private String requestContents;
    private String userId;
    private Date requestDate;
    private Boolean responseReceived;
    private Integer totalCount; // 전체 갯수

}