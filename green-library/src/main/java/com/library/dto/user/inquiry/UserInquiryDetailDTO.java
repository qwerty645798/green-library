package com.library.dto.user.inquiry;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInquiryDetailDTO {
    private String inquiryTitle;
    private String inquiryContents;
    private String responseContents;
}