package com.library.security;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHasher {
    
    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(PasswordHasher.class);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        Scanner scanner = new Scanner(System.in);
        
        logger.info("\n아이디를 입력해주세요 : ");
        String adminId = scanner.nextLine();
        
        logger.info("\n관리자 이름을 입력해주세요 : ");
        String adminName = scanner.nextLine();
        
        logger.info("\n비밀번호를 입력해주세요 : ");
        String rawPassword = scanner.nextLine();
        
        logger.info("\n이메일을 입력해주세요 : ");
        String adminEmail = scanner.nextLine();
        
        logger.info("\n관리자 등급을 입력해주세요 : ");
        String grantRank = scanner.nextLine();
        
        String encodedPassword = passwordEncoder.encode(rawPassword);
        
        scanner.close();
        String sql = "INSERT INTO admins " +
                "(ADMIN_ID, ADMIN_NAME, ADMIN_PASS, ADMIN_EMAIL, GRANT_RANK) " +
                "VALUES ('" + adminId + "', '" + adminName + "', '" + encodedPassword + "', '" + adminEmail + "', " + grantRank + ")";
   
        logger.info("\n보안에 주의하십시오.\n " + sql + ";");
    }
}