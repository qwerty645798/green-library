package com.library.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.library.controller.user.UserController;
import com.library.dto.assets.InitiativeBookDto;
import com.library.dto.assets.NotificationDetailDto;
import com.library.dto.assets.NotificationDto;
import com.library.dto.assets.PopularBookDto;
import com.library.dto.user.account.UserFindingIdDTO;
import com.library.dto.user.account.UserFindingPwDTO;
import com.library.dto.user.account.UserJoinDTO;
import com.library.dto.user.account.initializePasswordDTO;
import com.library.service.assets.InitiativeBookService;
import com.library.service.assets.NotificationDetailService;
import com.library.service.assets.NotificationService;
import com.library.service.assets.PopularBookService;
import com.library.service.user.UserService;

import jakarta.validation.Valid;

@Controller
public class MainController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	@Qualifier("UserService")
	UserService userService;

	@Autowired
	private InitiativeBookService initiativeBookService;
	@Autowired
	private PopularBookService popularBookService;
	@GetMapping("/")
	public String home(Model model) {
		List<InitiativeBookDto> initiative=
				initiativeBookService.getBookId();
				model.addAttribute("items", initiative);
		List<PopularBookDto> popular=
				popularBookService.getBookId();
				model.addAttribute("pops", popular);
		List<NotificationDto> announce=
				notificationService.findAnnounce2();
				model.addAttribute("announce", announce);
		return "index/index";
	}

	@GetMapping("/userJoin")
	public String userJoin(Model model) {
		model.addAttribute("userJoin", new UserJoinDTO());
		return "public/userJoin";
	}

	@PostMapping("/userJoin")
	public String userJoinPerform(@ModelAttribute("userJoin") @Valid UserJoinDTO userDTO, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> logger.error("Validation error: {}", error.getDefaultMessage()));
			redirectAttributes.addFlashAttribute("message", "유효하지 않은 입력입니다.");
			return "redirect:/userJoin";
		}
		
		boolean check = userService.checkUserAccount(userDTO);
		if(check) {
			redirectAttributes.addFlashAttribute("message", "이미 존재하는 사용자입니다.");
			return "redirect:/userFinding";
		}
			
		userService.insert(userDTO);
		redirectAttributes.addFlashAttribute("message", "회원가입이 완료되었습니다.");
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
	public String userFindingId(@ModelAttribute("user") @Valid UserFindingIdDTO userDTO, BindingResult result, Model model) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				logger.error("Validation error: {}", error.getDefaultMessage());
			}
			model.addAttribute("message", "유효하지 않은 입력입니다.");
			return "public/userFinding";
		}
		String userId = userService.findUserId(userDTO);
		model.addAttribute("userId", userId);
		return "public/userFinding";
	}
	
	@PostMapping("/userFindingPw")
	public String userFindingPw(@ModelAttribute("user") @Valid UserFindingPwDTO userDTO, BindingResult result, Model model) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				logger.error("Validation error: {}", error.getDefaultMessage());
			}
			model.addAttribute("message", "유효하지 않은 입력입니다.");
			return "public/userFinding";
		}
		userService.checkUserInfo(userDTO);
		model.addAttribute("message", "이메일 발송이 완료되었습니다.");
		return "public/userLogin";
	}

    @GetMapping("/verify")
    public String verifyEmail(@RequestParam(name = "token", required=false) String token, Model model) {
		String email = userService.verifyUser(token);
		model.addAttribute("email", email);
        return "public/initializePassword";
    }
    
    @PostMapping("/initializePassword")
    @ResponseBody
	public ResponseEntity<Map<String, Object>> initializePassword(@ModelAttribute("user") @Valid initializePasswordDTO userDTO, BindingResult result, Model model) {
    	userService.initializePassword(userDTO);
    	Map<String, Object> response = new HashMap<>();
    	if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				logger.error("Validation error: {}", error.getDefaultMessage());
				response.put("message", "유효하지 않은 입력입니다.");
	            response.put("success", false);
	            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
		}
		response.put("message", "비밀번호가 변경되었습니다.");
		response.put("success", true);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/userLogin")
	public String userLogin() {
		return "public/userLogin";
	}

	@GetMapping("/facilityInfo")
	public String facilityInfo() {
		return "public/facilityInfo";
	}

	@GetMapping("/privacyPolicy")
	public String privacyPolicy() {
		return "public/privacyPolicy";
	}

	@GetMapping("/floorInfo")
	public String floorInfo() {
		return "public/floorInfo";
	}

	@GetMapping("/dataRule")
	public String dataRule() {
		return "public/dataRule";
	}

	

	@GetMapping("/placeUsetime")
	public String placeUsetime() {
		return "public/placeUsetime";
	}

	@GetMapping("/wayToCome")
	public String wayToCome() {
		return "public/wayToCome";
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

		return "public/notification";
	}
	
	@PostMapping("/incrementViewCount")
	public void incrementViewCount(@RequestParam("announcementId") int announcementId) {
		 notificationDetailService.incrementViewCount(announcementId);
	}

	@Autowired
	private NotificationDetailService notificationDetailService;

	@GetMapping("/notificationDetail")
	public String notificationDetail(@RequestParam(name = "announcementId", required = false) String announcementId,
			Model model) {

		if (announcementId == null) {
			return "redirect:/";
		} // 리퀘파람 펄스 + 리다이렉트로 직접 bookdetail로 이동(bookId=null)은 인덱스로 돌려보냄
		
		notificationDetailService.incrementViewCount(Integer.parseInt(announcementId));

		NotificationDetailDto announceDetail = notificationDetailService.getAnnounceDetail(announcementId);
		model.addAttribute("announce", announceDetail);
		return "public/notificationDetail";
	}

	@GetMapping("/vision")
	public String vision() {
		return "public/vision";
	}

	@GetMapping("/schedule")
	public String schedule() {
		return "public/schedule";
	}

	// test
	@GetMapping("/inquiryTest")
	public String inquiryTest() {
		return "public/inquiryTest";
	}
	
	@GetMapping("/oftenAsk")
	public String oftenAsk() {
		return "public/oftenAsk";
	}
}
