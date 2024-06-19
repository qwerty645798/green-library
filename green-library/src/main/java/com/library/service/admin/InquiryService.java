package com.library.service.admin;

import com.library.dto.admin._normal.InquiryDTO;
import com.library.repository.admin.InquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InquiryService {

    @Autowired
    private InquiryRepository inquiryRepository;

    // 모든 문의 목록 조회
    public List<InquiryDTO> getAllInquiries() {
        return inquiryRepository.getAllInquiries();
    }

//    제목 검색
    public List<InquiryDTO> getInquiries(String title) {
        return inquiryRepository.searchByTitle(title);
    }


    public List<InquiryDTO> getInquires(String contents){
        return inquiryRepository.searchByContents(contents);
    }

    public List<InquiryDTO> AnsweredInquires(){
        return inquiryRepository.findAnsweredInquiries();
    }

    // 문의 상세 정보 조회
    public InquiryDTO getInquiryById(Integer inquiryId) {
        return inquiryRepository.findInquiryById(inquiryId);
    }


    // 문의 답변 등록
    @Transactional
    public void createInquiryResponse(Integer inquiryId, String responseContent, String adminId) {
        inquiryRepository.writeResponse(inquiryId, responseContent, adminId);
    }
}
