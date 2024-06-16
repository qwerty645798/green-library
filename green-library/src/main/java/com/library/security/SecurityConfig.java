package com.library.security;

@Configuration
public class SecurityConfig {

	@Autowired
	private SecurityUserService service;
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
    // 인가(접근권한) 설정
    http.authorizeHttpRequests().antMatchers("/").permitAll();
    http.authorizeHttpRequests().antMatchers("/admin/**").hasRole("ADMIN"); 
    http.authorizeHttpRequests().antMatchers("/user/**").hasAnyRole("ADMIN", "MEMBER");
    http.authorizeHttpRequests().antMatchers("/user2/loginSuccess").hasAnyRole("3", "4", "5");

    // 사이트 위변조 요청 방지 기본제공 
    //http.csrf().disable(); 비활성화코드

    // 로그인 설정
    http.formLogin()
    .loginPage("/user2/login")
    .defaultSuccessUrl("/user2/loginSuccess")
    .failureUrl("/user2/login?success=100)")
    .usernameParameter("uid")
    .passwordParameter("pass");
		
    // 로그아웃 설정
    http.logout()
    .invalidateHttpSession(true)
    .logoutRequestMatcher(new AntPathRequestMatcher("/user2/logout"))
    .logoutSuccessUrl("/user2/login?success=200");

    // 사용자 인증 처리 컴포넌트 서비스 등록
    http.userDetailsService(service);

    return http.build();
	}

    @Bean
    public PasswordEncoder PasswordEncoder () {
    	//return new MessageDigestPasswordEncoder("SHA-256");
    	return new BCryptPasswordEncoder();
    }
}

