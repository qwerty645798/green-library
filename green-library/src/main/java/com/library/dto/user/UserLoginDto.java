package com.library.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserLoginDto {
	
	@NotBlank(message = "아이디를 입력하지 않았습니다.")
	@Pattern(regexp = "^[a-z0-9]{5,15}$", message = "아이디는 5자 이상 15자 이하 영문 소문자와 숫자로 구성되어야 합니다.")
	@Size(min = 5, max = 15, message = "아이디는 5자 이상, 15자 이하로 입력해주세요.")
	private String user_id;

	@NotBlank(message = "비밀번호를 입력하지 않았습니다.")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#^*_])[A-Za-z\\d!@#^*_]{8,20}$", message = "비밀번호는 8~20자로 숫자, 영문 대소문자, 특수문자 중 3가지 이상 조합이어야 합니다. 사용 가능한 특수문자는 !@#^*입니다.")
	@Size(min = 8, max = 20, message = "비밀번호는 8자 이상, 20자 이하로 입력해주세요.")
	private String user_pass;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
}
