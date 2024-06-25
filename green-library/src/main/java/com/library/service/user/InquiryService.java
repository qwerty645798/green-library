package com.library.service.user;

import java.util.List;

import com.library.dto.user.inquiry.UserBorrowDTO;
import com.library.dto.user.inquiry.UserInterestDTO;
import com.library.dto.user.inquiry.UserRentHistoryDTO;
import com.library.dto.user.inquiry.UserReserveDTO;

public interface InquiryService {

	List<UserRentHistoryDTO> getUserRentHistory(String userId);

	List<UserBorrowDTO> getUserBorrow(String userId);

	List<UserReserveDTO> getUserReserve(String userId);

	List<UserInterestDTO> getUserInterest(String userId);

	void deleteRentHistory(String id);

	void cancelReserve(String id);

	void deleteInterest(String id);

}
