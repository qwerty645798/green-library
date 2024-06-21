package com.library.dto.admin.noticeManagement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticePaginationDTO {
    private int page;
    private int size;
    private int total;
    private int totalPages;
    private int totalElements;
    private int numberOfElements;
    private int numberOfPages;
}
