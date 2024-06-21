package com.library.service.admin;

import com.library.dto.admin._normal.InquiryDTO;
import com.library.repository.admin.InquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InquiryServiceImpl implements InquiryService{

    @Autowired
    private InquiryRepository inquiryRepository;

    // 모든 문의 조회
    @Override
    public List<InquiryDTO> allInquiryManage(){
        return inquiryRepository.allInquiryManage();
    }

    // 제목으로 조회
    @Override
    public List<InquiryDTO> findInquiryByTitle(String title){
        return inquiryRepository.findInquiryByTitle(title);
    }

    // 내용으로 조회
    @Override
    public List<InquiryDTO> findInquiryByContents(String contents){
        return inquiryRepository.findInquiryByContents(contents);
    }

    // 답변된 문의사항 조회
    @Override
    public List<InquiryDTO> findAnsweredInquiry(){
        return inquiryRepository.findAnsweredInquiry();
    }

    // 답변 생성
    @Override
    public void createInquiry(int inquiryId, String responseContent, String adminId) {
        inquiryRepository.createInquiry(inquiryId, responseContent, adminId);
    }

    // 답변 삭제
    @Override
    public void deleteInquiry(int id){
        inquiryRepository.deleteInquiry(id);
    }

    // 특정 문의사항 상세 조회
    @Override
    public InquiryDTO getInquiryById(int id){
        return inquiryRepository.getInquiryById(id);
    }

    // 이전 문의사항 제목 조회
    @Override
    public String previousInquiry(int id){
        return inquiryRepository.previousInquiry(id);
    }

    // 다음 문의사항 제목 조회
    @Override
    public String nextInquiry(int id){
        return inquiryRepository.nextInquiry(id);
    }
}
