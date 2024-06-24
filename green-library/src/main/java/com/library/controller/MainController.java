package com.library.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.library.controller.user.UserController;
import com.library.dto.assets.NotificationDetailDto;
import com.library.dto.assets.NotificationDto;
import com.library.dto.user.UserFindingIdDTO;
import com.library.dto.user.UserJoinDTO;
import com.library.service.assets.NotificationDetailService;
import com.library.service.assets.NotificationService;
import com.library.service.user.UserService;

import jakarta.validation.Valid;

@Controller
public class MainController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	@Qualifier("UserService")
	UserService userService;

	@GetMapping("/")
	public String home() {
		return "index/index";
	}

	@GetMapping("/userJoin")
	public String userJoin(Model model) {
		model.addAttribute("userJoin", new UserJoinDTO());
		logger.info("회원가입 시작");
		return "public/userJoin";
	}

	@PostMapping("/userJoin")
	public String userJoinPerform(@ModelAttribute("userJoin") @Valid UserJoinDTO userDTO, BindingResult result,
			RedirectAttributes redirectAttributes) {
		logger.info("회원가입 중간");
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> logger.error("Validation error: {}", error.getDefaultMessage()));
			redirectAttributes.addFlashAttribute("message", "유효하지 않은 입력입니다.");
			return "redirect:/userJoin";
		}
		logger.info("회원가입 후반");
		userService.insert(userDTO);
		logger.info("회원가입 끝");
		return "redirect:/userLogin";
	}

	@GetMapping("/checkUserId")
	@ResponseBody
	public boolean checkUserId(@RequestParam("user_id") String userId) {
		return userService.checkUserId(userId);
	}

	@GetMapping("/userAgreement")
	public String userAgreement() {
		return "public/userAgreement";
	}

	@GetMapping("/userFinding")
	public String userFinding() {
		return "public/userFinding";
	}

	@PostMapping("/userFindingId")
	public String userFindingId(@ModelAttribute("user") @Valid UserFindingIdDTO userDTO, BindingResult result) {
		if (result.hasErrors()) {// 미완성
			return "redirect:/userFinding?message=invalidValue";
		}
		// 미완성
		return "redirect:/userLogin";
	}

	@PostMapping("/userFindingPw")
	public String userFindingPw() {
		return "public/userFinding";
	}

	@GetMapping("/userLogin")
	public String userLogin() {
		return "public/userLogin";
	}

	@GetMapping("/facilityInfo")
	public String facilityInfo() {
		return "facilityInfo";
	}

	@GetMapping("/privacyPolicy")
	public String privacyPolicy() {
		return "privacyPolicy";
	}

	@GetMapping("/floorInfo")
	public String floorInfo() {
		return "floorInfo";
	}

	@GetMapping("/dataRule")
	public String dataRule() {
		return "dataRule";
	}

	@GetMapping("/hopeBookApply")
	public String hopeBookApply() {
		return "hopeBookApply";
	}

	@GetMapping("/placeUsetime")
	public String placeUsetime() {
		return "placeUsetime";
	}

	@GetMapping("/wayToCome")
	public String wayToCome() {
		return "wayToCome";
	}

	// david
	@Autowired
	private NotificationService notificationService;

	@GetMapping("/notification")
	public String notification(@RequestParam(name = "inputCategory", required = false) String inputCategory,
			@RequestParam(name = "inputText", required = false) String inputText,
			@RequestParam(name = "itemsPerPage", required = false, defaultValue = "10") int itemsPerPage, Model model) {

		List<NotificationDto> announce = notificationService.findAnnounce(inputCategory, inputText);
		model.addAttribute("announces", announce);
		model.addAttribute("inputCategory", inputCategory);
		model.addAttribute("inputText", inputText);
		model.addAttribute("itemsPerPage", itemsPerPage);

		return "notification";
	}
	
	@PostMapping("/incrementViewCount")
	public void incrementViewCount(@RequestParam("announcementId") int announcementId) {
		 notificationService.incrementViewCount(announcementId);
	}

	@Autowired
	private NotificationDetailService notificationDetailService;

	@GetMapping("/notificationDetail")
	public String notificationDetail(@RequestParam(name = "announcementId", required = false) String announcementId,
			Model model) {

		if (announcementId == null) {
			return "redirect:/";
		} // 리퀘파람 펄스 + 리다이렉트로 직접 bookdetail로 이동(bookId=null)은 인덱스로 돌려보냄

		NotificationDetailDto announceDetail = notificationDetailService.getAnnounceDetail(announcementId);
		model.addAttribute("announce", announceDetail);
		return "notificationDetail";
	}

	@GetMapping("/vision")
	public String vision() {
		return "vision";
	}

	@GetMapping("/businessStructure")
	public String businessStructure() {
		return "businessStructure";
	}

	@GetMapping("/schedule")
	public String schedule() {
		return "schedule";
	}

	// test
	@GetMapping("/inquiryTest")
	public String inquiryTest() {
		return "inquiryTest";
	}

	@GetMapping("/missingServletRequestParam")
	public String missingServletRequestParam() {
		return "public/missingServletRequestParam";
	}
}
