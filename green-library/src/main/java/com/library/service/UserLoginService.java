package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.library.dto.UserLoginDto;
import com.library.repository.UserLoginRepository;



@Service
public class UserLoginService implements UserDetailsService {

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserLoginDto userLoginDto = userLoginRepository.findByUserId(userId);
        if (userLoginDto == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return User.withUsername(userLoginDto.getUserId())
                   .password(userLoginDto.getUserPass())
                   .authorities("USER")
                   .build();
    }
    
}