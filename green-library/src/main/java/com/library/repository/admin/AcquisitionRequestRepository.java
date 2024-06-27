package com.library.repository.admin;

import com.library.dto.admin._normal.WishlistDTO;
import java.util.List;

public interface AcquisitionRequestRepository {
    List<WishlistDTO> allAcquisitionManage();
    List<WishlistDTO> findAcquisitionByTotal(String total);
    List<WishlistDTO> findAcquisitionByTitle(String title);
    List<WishlistDTO> findAcquisitionByAuthor(String author);
    List<WishlistDTO> findAcquisitionByGenre(String genre);
    void acceptsAcquisition(Integer requestId);
    void deleteAcquisition(Integer requestId);
}
