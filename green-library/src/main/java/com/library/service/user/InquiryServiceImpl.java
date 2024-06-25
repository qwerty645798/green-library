package com.library.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.library.dto.user.inquiry.UserBorrowDTO;
import com.library.dto.user.inquiry.UserCountDTO;
import com.library.dto.user.inquiry.UserInquiryDetailDTO;
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
	public boolean checkRentCondition(String userId, String id) {
		try {
            String check = inquiryRepository.checkRentCondition(userId, id);
            if(check.equals("0"))
            	return false;
            else
            	return true;
        } catch (DataAccessException e) {
            throw new DatabaseException("Database error occurred while checking user's rent condition with id: " + userId, e);
        }
	}
	
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
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteRentHistory(String userId, String id) {
		try {
			if(checkRentCondition(userId, id)) {
				int rowsAffected = inquiryRepository.deleteRentHistory(id);
				if (rowsAffected == 0) {
		            throw new DatabaseException("Failed to delete rent history with id: " + id);
		        }
			}
        } catch (DataAccessException e) {
            throw new DatabaseException("Database error occurred while removing user's rent history with id: " + id, e);
        }
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void cancelReserve(String id) {
		try {
			int rowsAffected = inquiryRepository.cancelReserve(id);
            if (rowsAffected == 0) {
	            throw new DatabaseException("Failed to cancel reservation with id: " + id);
	        }
        } catch (DataAccessException e) {
            throw new DatabaseException("Database error occurred while cancelling reservation with id: " + id, e);
        }
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteInterest(String id) {
		try {
			int rowsAffected = inquiryRepository.deleteInterest(id);
            if (rowsAffected == 0) {
	            throw new DatabaseException("Failed to delete interest with id: " + id);
	        }
        } catch (DataAccessException e) {
            throw new DatabaseException("Database error occurred while removing interest with id: " + id, e);
        }
	}
	
	@Override
	public UserCountDTO getUserCount(String userId) {
		try {
            return inquiryRepository.getUserCount(userId);
        } catch (DataAccessException e) {
            throw new DatabaseException("Database error occurred while checking user's count with id: " + userId, e);
        }
	}
	
	@Override 
	public UserInquiryDetailDTO getInquiryDetail(String userId, String id) {
            return inquiryRepository.getInquiryDetail(userId, id);
	}
}
