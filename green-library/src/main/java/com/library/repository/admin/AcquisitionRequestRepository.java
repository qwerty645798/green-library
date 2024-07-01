package com.library.repository.admin;

import com.library.dto.admin._normal.WishlistDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface AcquisitionRequestRepository {
    List<WishlistDTO> allAcquisitionManage();
    List<WishlistDTO> findAcquisitionByTotal(String total);
    List<WishlistDTO> findAcquisitionByTitle(String title);
    List<WishlistDTO> findAcquisitionByAuthor(String author);
    List<WishlistDTO> findAcquisitionByPublish(String publish);
    void acceptsAcquisition(List<String> requestId);
    void deleteAcquisition(List<String> requestId);
}
