package com.library.dto.admin._normal;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class InquiryResponseDTO {
    @NotNull
    private Long responseId;
    @NotNull
    private Long inquiryId;
    private Date responseDate;
    private String responseContent;
    @NotNull
    private String adminId;

}

