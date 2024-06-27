package com.library.dto.user.account;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class initializePasswordDTO {
	
	@NotBlank(message = "비밀번호를 입력하지 않았습니다.")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#^*_])[A-Za-z\\d!@#^*_]{8,20}$", message = "비밀번호는 8~20자로 숫자, 영문 대소문자, 특수문자 중 3가지 이상 조합이어야 합니다. 사용 가능한 특수문자는 !@#^*입니다.")
	@Size(min = 8, max = 20, message = "비밀번호는 8자 이상, 20자 이하로 입력해주세요.")
	private String user_pass;
	
	@NotBlank(message = "이메일을 입력하지 않았습니다.")
	@Email
	private String email;
}
