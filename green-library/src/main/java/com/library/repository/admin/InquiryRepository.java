package com.library.repository.admin;

import com.library.dto.admin._normal.InquiryDTO;

import java.util.List;

public interface InquiryRepository {

    // 모든 문의 목록 조회
    List<InquiryDTO> findAllInquiries();

    // 응답 여부에 따른 문의 목록 조회
    List<InquiryDTO> findInquiriesByResponseTF(boolean responseTF);

    // 전체에서 문의 조회
    List<InquiryDTO> findInquiriesByTotal(String total);
    List<InquiryDTO> findInquiriesByTotalAndResponseTF(String total, boolean responseTF);

    // 제목으로 문의 검색
    List<InquiryDTO> findInquiriesByTitle(String keyword);
    List<InquiryDTO> findInquiriesByTitleAndResponseTF(String keyword, boolean responseTF);

    // 내용으로 문의 검색
    List<InquiryDTO> findInquiriesByContents(String keyword);
    List<InquiryDTO> findInquiriesByContentsAndResponseTF(String keyword, boolean responseTF);


    // 문의 상세 정보 조회 및 답변 번호 포함
    InquiryDTO getInquiryById(int inquiryId);

    // 문의 답변 등록
    void createInquiry(Integer inquiryId, String responseContent, String adminId);

    // 삭제
    void deleteInquiry(List<String> userIds);

    // 이전 제목 조회
    InquiryDTO getPreviousInquiry(int inquiryId);

    InquiryDTO getNextInquiry(int inquiryId);
}
