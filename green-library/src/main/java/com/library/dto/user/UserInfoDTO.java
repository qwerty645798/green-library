package com.library.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoDTO {
	private String user_id;
    private String name;
    private String birth;
    private String phone;
    private String email;
}
