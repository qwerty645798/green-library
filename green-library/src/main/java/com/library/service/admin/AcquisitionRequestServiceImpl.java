package com.library.service.admin;

import com.library.dto.admin._normal.WishlistDTO;
import com.library.repository.admin.AcquisitionRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcquisitionRequestServiceImpl implements AcquisitionRequestService {

    @Autowired
    private AcquisitionRequestRepository acquisitionRequestRepository;

    //    전체 확인
    @Override
    public List<WishlistDTO> allAcquisitionManage() {
        return acquisitionRequestRepository.allAcquisitionManage();
    }

    @Override
    public List<WishlistDTO> findAcquisitionByTotal(String total) {
        return acquisitionRequestRepository.findAcquisitionByTotal(total);
    }

    //    제목으로 확인
    @Override
    public List<WishlistDTO> findAcquisitionByTitle(String title) {
        return acquisitionRequestRepository.findAcquisitionByTitle(title);
    }

    //     저자로 확인
    @Override
    public List<WishlistDTO> findAcquisitionByAuthor(String author) {
        return acquisitionRequestRepository.findAcquisitionByAuthor(author);
    }

    //     십진분류로 확인
    @Override
    public List<WishlistDTO> findAcquisitionByPublish(String publish) {
        return acquisitionRequestRepository.findAcquisitionByPublish(publish);
    }

    //    구매승인
    @Override
    public WishlistDTO acceptsAcquisition(int requestId) {
        acquisitionRequestRepository.acceptsAcquisition(requestId);
        return null;
    }

    //    구매거절
    @Override
    public WishlistDTO deleteAcquisition(int requestId) {
        acquisitionRequestRepository.deleteAcquisition(requestId);
        return null;
    }
}