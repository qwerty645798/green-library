package com.library.service.admin;

import com.library.dto.admin._normal.InquiryDTO;

import java.util.List;

public interface InquiryService {

    // 모든 문의 조회
    List<InquiryDTO> allInquiryManage(boolean showAnswered, boolean showOnlyAnswered);

    // 전체에서 조회
    List<InquiryDTO> findInquiryByTotal(String searchKeyword, boolean showAnswered, boolean showOnlyAnswered);

    // 제목으로 조회
    List<InquiryDTO> findInquiryByTitle(String title, boolean showAnswered, boolean showOnlyAnswered);

    // 내용으로 조회
    List<InquiryDTO> findInquiryByContents(String contents, boolean showAnswered, boolean showOnlyAnswered);

    // 기본 검색
    List<InquiryDTO> searchInquiries(String searchType, String searchKeyword, boolean showAnswered, boolean showOnlyAnswered);

    // 답변 생성
    void createInquiry(int inquiryId, String responseContent, String adminId);

    // 답변 삭제
    void deleteInquiry(List<String> userIds);

    // 특정 문의사항 상세 조회
    InquiryDTO getInquiryById(int id);

    // 이전 문의사항 제목 조회
    InquiryDTO previousInquiry(int id);

    // 다음 문의사항 제목 조회
    InquiryDTO nextInquiry(int id);
}
