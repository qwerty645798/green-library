package com.library.service.admin;

import com.library.dto.admin._normal.WishlistDTO;
import com.library.repository.admin.AcquisitionRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AcquisitionRequestService {

    //    전체 확인
    public List<WishlistDTO> allAcquisitionManage();

    //    제목으로 확인
    public List<WishlistDTO> findAcquisitionByTitle(String title);

    //     저자로 확인
    public List<WishlistDTO> findAcquisitionByAuthor(String author);

    //     십진분류로 확인
    public List<WishlistDTO> findAcquisitionByGenre(String author);

    //    구매승인
    public WishlistDTO acceptsAcquisition(int requestId);

    //    구매거절
    public WishlistDTO deleteAcquisition(int requestId);
}
