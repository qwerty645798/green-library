package com.library.dto.admin._normal;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class InquiryResponseDTO {
    @NotNull
    private int responseId;
    @NotNull
    private int inquiryId;
    private Date responseDate;
    private String responseContent;
    private String files;
    @NotNull
    private String adminId;
}

