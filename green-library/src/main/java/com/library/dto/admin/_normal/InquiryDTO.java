package com.library.dto.admin._normal;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class InquiryDTO {
    @NotNull
    private int inquiryId;
    private String inquiryTitle;
    private String contents;
    @NotNull
    private String userId;
    private Date inquiryDate;
    @NotNull
    private Character ResponseTF;

}

