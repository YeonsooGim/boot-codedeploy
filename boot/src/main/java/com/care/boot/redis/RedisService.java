package com.care.boot.redis;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.care.boot.member.MemberDTO;

@Service
public class RedisService {
	@Autowired	
	private RedisTemplate<String, Object> redisTemplate;
	
	public void save(String key, String value) {
		redisTemplate.opsForValue().set(key, value);
	}

	public String getValue(String key) {
		return (String) redisTemplate.opsForValue().get(key);
	}

	public void delete(String key) {
		redisTemplate.delete(key);
	}
	
	public void saves(String key, MemberDTO value) {
		Map<String, MemberDTO> map = new HashMap<>();
		map.put(value.getId(), value);
		redisTemplate.opsForHash().putAll(key, map);
	}
	public MemberDTO getValues(String key, String userId) {
		Map<Object, Object> map = redisTemplate.opsForHash().entries(key);
		return (MemberDTO)map.get(userId);
	}
	public void deletes(String key, String userId) {
		redisTemplate.opsForHash().delete(key, userId);
	}
	
}
