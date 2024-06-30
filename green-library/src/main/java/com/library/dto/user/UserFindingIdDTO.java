package com.library.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserFindingIdDTO {

	@NotBlank(message = "이름을 입력하지 않았습니다.")
	@Pattern(regexp = "^[가-힣]{2,5}$", message = "이름은 한글 2자 이상 5자 이하로 입력해주세요.")
	@Size(min = 2, max = 5, message = "이름은 2자 이상, 5자 이하로 입력해주세요.")
	private String name;

	@NotBlank(message = "이메일을 입력하지 않았습니다.")
	@Email
	private String email;
	
	@NotBlank(message = "생년월일을 입력하지 않았습니다.")
	@Pattern(regexp = "^(19\\d{2}|20[0-2][0-3])-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$", message = "생년월일은 'yyyy-MM-dd' 형식이며, 2024년 이전이어야 합니다.")
	private String birth;

}
