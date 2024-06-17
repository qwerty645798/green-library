package com.library.service.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.library.dto.user.UserLoginDto;
import com.library.repository.user.UserLoginRepository;



@Service
public class UserLoginService implements UserDetailsService {

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserLoginDto userLoginDto = userLoginRepository.findByUserId(userId);
        if (userLoginDto == null) {
            throw new UsernameNotFoundException("UserLoginDto not found");
        }
        
        List<GrantedAuthority> authorities = new ArrayList<>();
        
        return User.withUsername(userLoginDto.getUserId())
                   .password(userLoginDto.getUserPass())
                   .authorities(authorities)
                   .build();
    }
    
}