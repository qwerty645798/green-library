package com.library.security;

import java.io.IOException;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.INCLUDE).permitAll()
                .requestMatchers("/resources/static/**").permitAll()
                .requestMatchers("/admin").permitAll()
                .requestMatchers("/admin/css/**").permitAll()
                .requestMatchers("/admin/js/**").permitAll()
                .requestMatchers("/admin/assets/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/user/**").authenticated()
                .anyRequest().permitAll()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .successHandler(customAuthenticationSuccessHandler())
                .failureHandler(customAuthenticationFailureHandler())
                .usernameParameter("id")
                .passwordParameter("pass")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessHandler(customLogoutSuccessHandler())
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
            )
            .exceptionHandling(exception -> exception
            		.authenticationEntryPoint(customAuthenticationEntryPoint())
            );

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

    @Bean
    protected AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
        return new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                org.springframework.security.core.Authentication authentication) throws java.io.IOException {
                String redirectUrl = request.getContextPath();
                String referer = request.getHeader("Referer");

                if (referer != null && referer.contains("/admin")) {
                    if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
                        redirectUrl = request.getContextPath() + "/adminIndex"; // 관리자 로그인 성공 후 리다이렉트 URL
                    } else {
                        redirectUrl = request.getContextPath() + "/admin?error=true"; // 관리자 권한이 없는 경우
                    }
                } else {
                    if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_USER"))) {
                        redirectUrl = request.getContextPath() + "/"; // 사용자 로그인 성공 후 리다이렉트 URL
                    } else {
                        redirectUrl = request.getContextPath() + "/userLogin?error=true"; // 사용자 권한이 없는 경우
                    }
                }

                response.sendRedirect(redirectUrl);
            }
        };
    }

    @Bean
    protected AuthenticationFailureHandler customAuthenticationFailureHandler() {
        return new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                                org.springframework.security.core.AuthenticationException exception) throws java.io.IOException {
                String failureUrl = request.getContextPath() + "/login?error=true";
                String referer = request.getHeader("Referer");

                if (referer != null && referer.contains("/admin")) {
                    failureUrl = request.getContextPath() + "/admin?error=true";
                }
                else 
                	failureUrl = request.getContextPath() + "/userLogin?error=true";
                response.sendRedirect(failureUrl);
            }
        };
    }

    @Bean
    protected LogoutSuccessHandler customLogoutSuccessHandler() {
        return new LogoutSuccessHandler() {
            @Override
            public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, 
                                        org.springframework.security.core.Authentication authentication) throws java.io.IOException {
                String redirectUrl = request.getContextPath();
                if (authentication != null && authentication.getAuthorities().stream()
                        .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
                    redirectUrl = "/admin"; // 관리자 로그아웃 성공 후 리다이렉트 URL
                } else {
                    redirectUrl = "/"; // 사용자 로그아웃 성공 후 리다이렉트 URL
                }
                response.sendRedirect(redirectUrl);
            }
        };
    }
    
    @Bean
    protected AuthenticationEntryPoint customAuthenticationEntryPoint() {
        return new AuthenticationEntryPoint() {
            @Override
            public void commence(HttpServletRequest request, HttpServletResponse response,
                                 AuthenticationException authException) throws IOException {
                String redirectUrl = request.getContextPath() + "/login";
                String uri = request.getRequestURI();

                if (uri.startsWith(request.getContextPath() + "/admin")) {
                    redirectUrl = request.getContextPath() + "/admin?auth=none";
                } else {
                    redirectUrl = request.getContextPath() + "/userLogin?auth=none";
                }

                response.sendRedirect(redirectUrl);
            }
        };
    }
}
