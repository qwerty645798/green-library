package com.library.service.user;

import java.util.List;

import com.library.dto.user.inquiry.UserBorrowDTO;
import com.library.dto.user.inquiry.UserCountDTO;
import com.library.dto.user.inquiry.UserInquiryDetailDTO;
import com.library.dto.user.inquiry.UserInterestDTO;
import com.library.dto.user.inquiry.UserRentHistoryDTO;
import com.library.dto.user.inquiry.UserReserveDTO;

public interface InquiryService {

	List<UserRentHistoryDTO> getUserRentHistory(String userId);

	List<UserBorrowDTO> getUserBorrow(String userId);

	List<UserReserveDTO> getUserReserve(String userId);

	List<UserInterestDTO> getUserInterest(String userId);

	void deleteRentHistory(String userId, String id);

	void cancelReserve(String id);

	void deleteInterest(String id);

	boolean checkRentCondition(String userId, String id);

	UserCountDTO getUserCount(String userId);

	UserInquiryDetailDTO getInquiryDetail(String userId, String id);

}
