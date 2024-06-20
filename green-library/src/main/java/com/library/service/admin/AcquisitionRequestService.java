package com.library.service.admin;

import com.library.dto.admin._normal.WishlistDTO;
import com.library.repository.admin.AcquisitionRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcquisitionRequestService {

    @Autowired
    private AcquisitionRequestRepository acquisitionRequestRepository;
//    전체 확인
    public List<WishlistDTO> allAcquisitionManage() {
        return acquisitionRequestRepository.allAcquisitionManage();
    }

//    제목으로 확인
    public List<WishlistDTO> findAcquisitionByTitle(String title) {
        return acquisitionRequestRepository.findAcquisitionByTitle(title);
    }
    
//     저자로 확인
    public List<WishlistDTO> findAcquisitionByAuthor(String author) {
        return acquisitionRequestRepository.findAcquisitionByAuthor(author);
    }
    
    //     십진분류로 확인
    public List<WishlistDTO> findAcquisitionByGenre(String author) {
        return acquisitionRequestRepository.findAcquisitionByGenre(author);
    }
    
//    구매승인
    public WishlistDTO acceptsAcquisition(int requestId) {
        acquisitionRequestRepository.acceptsAcquisition(requestId);
        return null;
    }

//    구매거절
    public WishlistDTO deleteAcquisition(int requestId) {
        acquisitionRequestRepository.deleteAcquisition(requestId);
        return null;
    }
}
