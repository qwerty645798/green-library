package com.library.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Users {
    private String user_id;
    private String user_pass;
    private String name;
    private String email;
    private String phone;
    private String birth;
    private Integer overdue_count = 0;
    private Character suspended = '0';

}
