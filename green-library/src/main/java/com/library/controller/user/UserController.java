package com.library.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.library.dto.user.inquiry.UserBorrowDTO;
import com.library.dto.user.inquiry.UserCountDTO;
import com.library.dto.user.inquiry.UserInquiryDetailDTO;
import com.library.dto.user.inquiry.UserInterestDTO;
import com.library.dto.user.inquiry.UserRentHistoryDTO;
import com.library.dto.user.inquiry.UserReserveDTO;
import com.library.dto.user.profile.UserInfoDTO;
import com.library.dto.user.profile.UserInfoModificationDTO;
import com.library.service.user.InquiryService;
import com.library.service.user.UserService;

import jakarta.validation.Valid;

@Controller("UserController")
//@RequestMapping("/user")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	@Qualifier("UserService")
	private UserService userService;

	@Autowired
	@Qualifier("UserInquiryService")
	private InquiryService inquiryService;

	@GetMapping("/userInfo")
	public String userInfo(Model model, @RequestParam(name = "auth", defaultValue = "abc") String userId) {
		logger.info("Received auth: {}", userId);
		UserInfoDTO userDTO = userService.getUserInfo(userId);
		model.addAttribute("userInfo", userDTO);
		return "user/userInfo";
	}

	@GetMapping("/userInfoModification")
	public String userInfoModification(Model model, @RequestParam(name = "auth", defaultValue = "abc") String userId) {

		UserInfoDTO userDTO = userService.getUserInfo(userId);
		model.addAttribute("userInfo", userDTO);
		return "user/userInfoModification";
	}

	@PostMapping("/userInfoModification")
	public String userInfoModificationPerform(
			@ModelAttribute("userInfo") @Valid UserInfoModificationDTO userInfoModificationDTO,
			@RequestParam(name = "auth", defaultValue = "abc") String userId, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				logger.error("Validation error: {}", error.getDefaultMessage());
			}
			model.addAttribute("message", "유효하지 않은 입력입니다.");
			return "userInfoModification";
		}

		userService.update(userInfoModificationDTO, userId);
		redirectAttributes.addFlashAttribute("message", "회원정보가 수정되었습니다.");
		return "redirect:/userInfo";
	}

	@PostMapping("/userDelete")
	public String userDelete(@RequestParam(name = "auth", defaultValue = "abc") String userId,
			RedirectAttributes redirectAttributes) {
		userService.deleteUser(userId);
		redirectAttributes.addFlashAttribute("message", "userDelete");
		return "redirect:/";
	}

	@GetMapping("/userUseInformation")
	public String userUseInformation(@RequestParam(name = "auth", defaultValue = "abc") String userId, Model model) {
		UserCountDTO userDTO = inquiryService.getUserCount(userId);
		model.addAttribute("count", userDTO);
		return "user/userUseInformation";
	}

	@GetMapping("/useInformationBoard")
    public String useInformationBoard() {
        return "user/useInformation/board";
    }
	
	@GetMapping("/getUserData")
    @ResponseBody
    public Map<String, Object> getAllData(@RequestParam(name = "auth", defaultValue = "abc") String userId) {
        Map<String, Object> response = new HashMap<>();

        List<UserRentHistoryDTO> rentHistory = inquiryService.getUserRentHistory(userId);
        List<UserBorrowDTO> borrow = inquiryService.getUserBorrow(userId);
        List<UserReserveDTO> reserve = inquiryService.getUserReserve(userId);
		List<UserInterestDTO> interest = inquiryService.getUserInterest(userId);

        response.put("rentHistory", rentHistory);
        response.put("borrow", borrow);
        response.put("reserve", reserve);
		response.put("interest", interest);

        return response;
    }
	
	@PostMapping("/deleteRentHistory")
    @ResponseBody
    public Map<String, Object> deleteRentHistory(@RequestParam(name = "auth", defaultValue = "abc") String userId, @RequestParam("id") String id) {

		inquiryService.deleteRentHistory(userId, id);

		
        List<UserRentHistoryDTO> updatedRentHistory = inquiryService.getUserRentHistory(userId);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", updatedRentHistory);
        
        return response;
    }

    @PostMapping("/cancelReserve")
    @ResponseBody
    public Map<String, Object> cancelReserve(@RequestParam(name = "auth", defaultValue = "abc") String userId, @RequestParam("id") String id) {
    	
    	inquiryService.cancelReserve(id);
    	
        List<UserReserveDTO> updatedReserve = inquiryService.getUserReserve(userId);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", updatedReserve);
        
        return response;
    }

    @PostMapping("/deleteInterest")
    @ResponseBody
    public Map<String, Object> deleteInterest(@RequestParam(name = "auth", defaultValue = "abc") String userId, @RequestParam("id") String id) {
    	
    	inquiryService.deleteInterest(id);
    	
        List<UserInterestDTO> updatedInterest = inquiryService.getUserInterest(userId);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", updatedInterest);
        
        return response;
    }
    
    @GetMapping("/userInquiryDetail")
	public String userInquiryDetail(@RequestParam(name = "auth", defaultValue = "abc") String userId, @RequestParam("inquiryId") String id, Model model) {
    	UserInquiryDetailDTO userDTO = inquiryService.getInquiryDetail(userId, id);
    	model.addAttribute("inquiryDetail", userDTO);
    	return "user/userInquiryDetail";
	}
}
