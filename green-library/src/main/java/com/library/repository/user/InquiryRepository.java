package com.library.repository.user;

import java.util.List;

import com.library.dto.user.inquiry.UserBorrowDTO;
import com.library.dto.user.inquiry.UserCountDTO;
import com.library.dto.user.inquiry.UserInquiryDetailDTO;
import com.library.dto.user.inquiry.UserInterestDTO;
import com.library.dto.user.inquiry.UserRentHistoryDTO;
import com.library.dto.user.inquiry.UserReserveDTO;

public interface InquiryRepository {

	List<UserRentHistoryDTO> getUserRentHistory(String userId);

	List<UserBorrowDTO> getUserBorrow(String userId);

	List<UserReserveDTO> getUserReserve(String userId);

	List<UserInterestDTO> getUserInterest(String userId);

	int deleteRentHistory(String id);

	int cancelReserve(String id);

	int deleteInterest(String id);


	String checkRentCondition(String userId, String id);

	UserCountDTO getUserCount(String userId);

	UserInquiryDetailDTO getInquiryDetail(String userId, String id);

}
