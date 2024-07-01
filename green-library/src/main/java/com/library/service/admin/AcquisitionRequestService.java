package com.library.service.admin;

import com.library.dto.admin._normal.WishlistDTO;

import java.util.List;

public interface AcquisitionRequestService {

    //    전체 확인
    List<WishlistDTO> allAcquisitionManage();

    // 검색
    List<WishlistDTO>findAcquisitionByTotal(String total);

    //    제목으로 확인
    List<WishlistDTO> findAcquisitionByTitle(String title);

    //     저자로 확인
    List<WishlistDTO> findAcquisitionByAuthor(String author);

    //     십진분류로 확인
    List<WishlistDTO> findAcquisitionByPublish(String genre);

    //    구매승인
    WishlistDTO acceptsAcquisition(List<String> requestId);

    //    구매거절
    WishlistDTO deleteAcquisition(List<String> requestId);
}
