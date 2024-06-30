package com.library.service.admin;

import com.library.dto.admin._normal.InquiryDTO;
import com.library.repository.admin.InquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InquiryServiceImpl implements InquiryService {

    @Autowired
    private InquiryRepository inquiryRepository;

    @Override
    public List<InquiryDTO> allInquiryManage(boolean showAnswered, boolean showOnlyAnswered) {
        if (showOnlyAnswered) {
            return inquiryRepository.findInquiriesByResponseTF(true);
        } else if (showAnswered) {
            return inquiryRepository.findAllInquiries();
        } else {
            return inquiryRepository.findInquiriesByResponseTF(false);
        }
    }

    @Override
    public List<InquiryDTO> searchInquiries(String searchType, String searchKeyword, boolean showAnswered, boolean showOnlyAnswered) {
        switch (searchType) {
            case "title":
                return findInquiryByTitle(searchKeyword, showAnswered, showOnlyAnswered);
            case "contents":
                return findInquiryByContents(searchKeyword, showAnswered, showOnlyAnswered);
            default:
                return findInquiryByTotal(searchKeyword, showAnswered, showOnlyAnswered);
        }
    }

    @Override
    public List<InquiryDTO> findInquiryByTotal(String searchKeyword, boolean showAnswered, boolean showOnlyAnswered) {
        if (showOnlyAnswered) {
            return inquiryRepository.findInquiriesByTotalAndResponseTF(searchKeyword, true);
        } else if (showAnswered) {
            return inquiryRepository.findInquiriesByTotal(searchKeyword);
        } else {
            return inquiryRepository.findInquiriesByTotalAndResponseTF(searchKeyword, false);
        }
    }

    @Override
    public List<InquiryDTO> findInquiryByTitle(String title, boolean showAnswered, boolean showOnlyAnswered) {
        if (showOnlyAnswered) {
            return inquiryRepository.findInquiriesByTitleAndResponseTF(title, true);
        } else if (showAnswered) {
            return inquiryRepository.findInquiriesByTitle(title);
        } else {
            return inquiryRepository.findInquiriesByTitleAndResponseTF(title, false);
        }
    }

    @Override
    public List<InquiryDTO> findInquiryByContents(String contents, boolean showAnswered, boolean showOnlyAnswered) {
        if (showOnlyAnswered) {
            return inquiryRepository.findInquiriesByContentsAndResponseTF(contents, true);
        } else if (showAnswered) {
            return inquiryRepository.findInquiriesByContents(contents);
        } else {
            return inquiryRepository.findInquiriesByContentsAndResponseTF(contents, false);
        }
    }

    // 답변된 문의사항 조회
//    @Override
//    public List<InquiryDTO> findAnsweredInquiry(){
//        return inquiryRepository.findAnsweredInquiry();
//    }

    // 답변 생성
    @Override
    public void createInquiry(int inquiryId, String responseContent, String adminId) {
        inquiryRepository.createInquiry(inquiryId, responseContent, adminId);
    }

    // 답변 삭제
    @Override
    public void deleteInquiry(List<String> id){
        inquiryRepository.deleteInquiry(id);
    }

    // 특정 문의사항 상세 조회
    @Override
    public InquiryDTO getInquiryById(int id){
        return inquiryRepository.getInquiryById(id);
    }

    // 이전 문의사항 제목 조회
    @Override
    public InquiryDTO previousInquiry(int id){
        return inquiryRepository.getPreviousInquiry(id);
    }

    // 다음 문의사항 제목 조회
    @Override
    public InquiryDTO nextInquiry(int id){
        return inquiryRepository.getNextInquiry(id);
    }
}
