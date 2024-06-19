package com.library.dto.admin._normal;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {
    @NotNull
    private String userId;
    @NotNull
    private String userPass;
    private String userName;
    private String userEmail;
    private String userPhone;
    private String userBirth;
    private Long overdueCount;
    private Character suspended;
}
