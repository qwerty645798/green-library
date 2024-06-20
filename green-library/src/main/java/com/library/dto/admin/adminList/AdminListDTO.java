package com.library.dto.admin.adminList;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdminListDTO {
    private String adminID;
    private String adminName;
    private String adminEmail;
    private String grantRank;
}
