package com.library.service.user;

import java.util.List;

import com.library.dto.user.UserRentHistoryDTO;

public interface InquiryService {

	List<UserRentHistoryDTO> getUserRentHistory(String userId);

}
