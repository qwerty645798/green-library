package com.library.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.library.dto.user.inquiry.UserBorrowDTO;
import com.library.dto.user.inquiry.UserInterestDTO;
import com.library.dto.user.inquiry.UserRentHistoryDTO;
import com.library.dto.user.inquiry.UserReserveDTO;
import com.library.exception.DatabaseException;
import com.library.repository.user.InquiryRepository;

@Service("UserInquiryService")
public class InquiryServiceImpl implements InquiryService{

	@Autowired
	@Qualifier("UserInquiryRepository")
	InquiryRepository inquiryRepository;
	
	@Override
	public List<UserRentHistoryDTO> getUserRentHistory(String userId) {
		try {
            return inquiryRepository.getUserRentHistory(userId);
        } catch (DataAccessException e) {
            throw new DatabaseException("Database error occurred while inquirying user's rent history with id: " + userId, e);
        }
	}
	
	@Override
	public List<UserBorrowDTO> getUserBorrow(String userId) {
		try {
            return inquiryRepository.getUserBorrow(userId);
        } catch (DataAccessException e) {
            throw new DatabaseException("Database error occurred while inquirying user's borrow history with id: " + userId, e);
        }
	}
	
	@Override
	public List<UserReserveDTO> getUserReserve(String userId) {
		try {
            return inquiryRepository.getUserReserve(userId);
        } catch (DataAccessException e) {
            throw new DatabaseException("Database error occurred while inquirying user's reserve history with id: " + userId, e);
        }
	}
	
	@Override
	public List<UserInterestDTO> getUserInterest(String userId) {
		try {
            return inquiryRepository.getUserInterest(userId);
        } catch (DataAccessException e) {
            throw new DatabaseException("Database error occurred while inquirying user's interest history with id: " + userId, e);
        }
	}
}
