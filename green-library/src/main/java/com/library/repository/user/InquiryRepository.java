package com.library.repository.user;

import java.util.List;

import com.library.dto.user.UserRentHistoryDTO;

public interface InquiryRepository {

	List<UserRentHistoryDTO> getUserRentHistory(String userId);

}
