package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.library.dto.UserDto;
import com.library.repository.UserRepository;



@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserDto userDto = userRepository.findByUserId(userId);
        if (userDto == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return User.withUsername(userDto.getUserId())
                   .password(userDto.getUserPass())
                   .authorities("USER")
                   .build();
    }
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public void saveUser(UserDto userDto) {
        userDto.setUserPass(passwordEncoder.encode(userDto.getUserPass()));
        //userRepository.save(userDto);
    }
}