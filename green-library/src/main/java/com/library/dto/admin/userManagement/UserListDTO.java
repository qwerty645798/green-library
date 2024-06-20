package com.library.dto.admin.userManagement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserListDTO {
    private String userID;
    private String username;
    private String userEmail;
}
