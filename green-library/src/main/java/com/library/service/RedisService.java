package com.library.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

	/*
	 * @Autowired private StringRedisTemplate redisTemplate;
	 * 
	 * public void saveToken(String token, String email) {
	 * redisTemplate.opsForValue().set(token, email, 15, TimeUnit.MINUTES); }
	 * 
	 * public String getEmailByToken(String token) { return
	 * redisTemplate.opsForValue().get(token); }
	 * 
	 * public void deleteToken(String token) { redisTemplate.delete(token); }
	 */
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void saveToken(String token, String email) {
		String sql = "INSERT INTO email_token (token, email) VALUES (?, ?)";
		jdbcTemplate.update(sql, token, email);
	}
	
	public String getEmailByToken(String token) {
		String sql = "SELECT email FROM email_token WHERE token = ?";
        return jdbcTemplate.queryForObject(sql, String.class, token);
	}

	public void deleteToken(String token) {
		String sql = "DELETE FROM email_token WHERE token = ?";
        jdbcTemplate.update(sql, token);
	}
}