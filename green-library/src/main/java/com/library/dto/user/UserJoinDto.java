package com.library.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserJoinDto {

	@NotBlank(message = "아이디를 입력하지 않았습니다.")
	@Pattern(regexp = "^[a-z0-9]{5,15}$", message = "아이디는 5자 이상 15자 이하 영문 소문자와 숫자로 구성되어야 합니다.")
	@Size(min = 5, max = 15, message = "아이디는 5자 이상, 15자 이하로 입력해주세요.")
	private String user_id;

	@NotBlank(message = "비밀번호를 입력하지 않았습니다.")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#^*_])[A-Za-z\\d!@#^*_]{8,20}$", message = "비밀번호는 8~20자로 숫자, 영문 대소문자, 특수문자 중 3가지 이상 조합이어야 합니다. 사용 가능한 특수문자는 !@#^*입니다.")
	@Size(min = 8, max = 20, message = "비밀번호는 8자 이상, 20자 이하로 입력해주세요.")
	private String user_pass;

	@NotBlank(message = "이름을 입력하지 않았습니다.")
	@Pattern(regexp = "^[가-힣]{2,5}$", message = "이름은 한글 2자 이상 5자 이하로 입력해주세요.")
	@Size(min = 2, max = 5, message = "이름은 2자 이상, 5자 이하로 입력해주세요.")
	private String name;

	@NotBlank(message = "이메일을 입력하지 않았습니다.")
	@Email
	private String email;

	@NotBlank(message = "전화번호를 입력하지 않았습니다.")
	@Pattern(regexp = "^01[016789]-?\\d{3,4}-?\\d{4}$", message = "휴대폰 번호는 '010-1234-5678' 또는 '01012345678' 형식으로 입력해주세요.")
	private String phone;

	@NotBlank(message = "생년월일을 입력하지 않았습니다.")
	@Pattern(regexp = "^(19\\d{2}|20[0-2][0-3])-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$", message = "생년월일은 'yyyy-MM-dd' 형식이며, 2024년 이전이어야 합니다.")
	private String birth;

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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}

}