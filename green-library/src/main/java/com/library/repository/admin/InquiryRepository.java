package com.library.repository.admin;

import com.library.dto.admin._normal.InquiryDTO;

import java.util.List;

public interface InquiryRepository {

    // 모든 문의 목록 조회
    List<InquiryDTO> allInquiryManage();

    // 제목으로 문의 검색
    List<InquiryDTO> findInquiryByTitle(String keyword);

    // 내용으로 문의 검색
    List<InquiryDTO> findInquiryByContents(String keyword);

    // 답변이 등록된 문의 목록 조회
    List<InquiryDTO> findAnsweredInquiry();

    // 문의 상세 정보 조회
    InquiryDTO getInquiryById(Integer inquiryId);

    // 문의 답변 등록
    void createInquiry(Integer inquiryId, String responseContent, String adminId);

    //    삭제
    void deleteInquiry(int id);

    // 이전 제목 조회
    String previousInquiry(int inquiryId);

    // 다음 제목 조회
    String nextInquiry(int inquiryId);
}
