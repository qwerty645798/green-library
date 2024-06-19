package com.library.dto.admin.userManagement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class UserDetailDTO {
    private String userID;
    private String username;
    private String userEmail;
    private String userPhone;
    private List<LoanStatusDTO> loanStatuses;
    private List<RestrictionDTO> restrictions;

}
