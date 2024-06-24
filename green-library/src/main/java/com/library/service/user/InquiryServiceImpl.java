package com.library.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.library.dto.user.UserRentHistoryDTO;
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
}
