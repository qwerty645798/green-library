package com.library.dto.admin.userManagement;

import com.library.dto.admin._normal.RentDTO;
import com.library.dto.admin._normal.SuspensionDTO;
import com.library.dto.admin._normal.UserDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class UserDetailDTO {
    private UserDTO user;
    private List<RentDTO> loans;
    private List<SuspensionDTO> suspensions;

}
