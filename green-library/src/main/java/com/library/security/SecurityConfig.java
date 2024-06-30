package com.library.security;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;

//import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import jakarta.servlet.DispatcherType;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
            	.dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.INCLUDE).permitAll()
                .requestMatchers("/**", "/static/admin/**", "/resources/**","/static/**","/css/**","/js/**","/images/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/user/**").authenticated()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/userLogin")
                .loginProcessingUrl("/userLogin")
                .failureUrl("/userLogin?error=true")
                .usernameParameter("user_id")
                .passwordParameter("user_pass")
                .defaultSuccessUrl("/", true)
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll()
            )
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .sessionFixation().migrateSession()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(false)
            )
            .headers(headers -> headers
            	.frameOptions(frameOptions -> frameOptions
            		.sameOrigin()
            	)
            );

//            .requiresChannel(channel -> channel
//                .anyRequest().requiresSecure()
//            )
//            .headers(headers -> headers
//                .httpStrictTransportSecurity(hsts -> hsts
//                    .includeSubDomains(true)
//                    .preload(true)
//                    .maxAgeInSeconds(31536000)
//                )
//            );

        return http.build();
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    protected ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
    	return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
    }
    
	/*
	 * @Bean WebSecurityCustomizer ignoringCustomizer() { return (web) ->
	 * web.ignoring().requestMatchers("/resources/**", "/static/**"); }
	 */
}

