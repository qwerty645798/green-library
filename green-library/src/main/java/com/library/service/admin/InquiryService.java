package com.library.service.admin;

import com.library.dto.admin._normal.InquiryDTO;

import java.util.List;

public interface InquiryService{

     // 모든 문의 조회
    List<InquiryDTO> allInquiryManage();
    // 제목으로 조회
    List<InquiryDTO> findInquiryByTitle(String title);
    // 내용으로 조회
    List<InquiryDTO> findInquiryByContents(String contents);
    // 답변된 문의사항 조회
    List<InquiryDTO> findAnsweredInquiry();
    // 답변 생성
    void createInquiry(int inquiryId, String responseContent, String adminId) ;
    // 답변 삭제
    void deleteInquiry(int id);
    // 특정 문의사항 상세 조회
    InquiryDTO getInquiryById(int id);
    // 이전 문의사항 제목 조회
    String previousInquiry(int id);
    // 다음 문의사항 제목 조회
    String nextInquiry(int id);

}
