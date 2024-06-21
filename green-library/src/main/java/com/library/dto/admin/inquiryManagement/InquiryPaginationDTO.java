package com.library.dto.admin.inquiryManagement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InquiryPaginationDTO {
    private int page;
    private int size;
    private int total;
    private int totalPages;
    private int totalElements;
    private int numberOfElements;
    private int numberOfPages;
}
