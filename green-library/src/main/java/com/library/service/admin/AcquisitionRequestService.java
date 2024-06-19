package com.library.service.admin;

import com.library.dto.admin.acquisitionManagement.AcquisitionRequestDTO;
import com.library.repository.admin.AcquisitionRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//service에서 걸러서, data 가공 처리

@Service
public class AcquisitionRequestService {

    @Autowired
    private AcquisitionRequestRepository acquisitionRequestRepository;

    // 도서 획득 요청 목록 조회
    public List<AcquisitionRequestDTO> getAcquisitionRequests() {
        return acquisitionRequestRepository.acquisitionRequestManage();
    }

    // 도서 획득 요청 등록
    @Transactional
    public void createAcquisitionRequest(int bookId, String summary, String requestStatus) {
        acquisitionRequestRepository.createAcquisitionRequest(bookId, summary, requestStatus);
    }

    // 도서 획득 요청 상세 조회
    public AcquisitionRequestDTO getAcquisitionRequestById(int requestId) {
        return acquisitionRequestRepository.findAcquisitionRequestById(requestId);
    }

    // 도서 획득 요청 상태 업데이트
    @Transactional
    public void updateRequestStatus(int requestId, String requestStatus) {
        acquisitionRequestRepository.updateRequestStatus(requestId, requestStatus);
    }

    // 도서 획득 요청 삭제
    @Transactional
    public void deleteAcquisitionRequest(int requestId) {
        acquisitionRequestRepository.deleteAcquisitionRequest(requestId);
    }
}
