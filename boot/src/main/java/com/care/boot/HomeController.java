package com.care.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.boot.redis.RedisService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired private RedisService redisService;
	@Autowired private HttpServletRequest request;
	@Autowired private HttpSession session;
	
	@RequestMapping("index")
	public void index() {}
	
	@RequestMapping("header")
	public String header() {
		return "default/header";
	}
	@RequestMapping("main")
	public String main() {
		String userId = redisService.getValue(request.getSession().getId());
		session.setAttribute(userId, userId);
		return "default/main";
	}
	@RequestMapping("footer")
	public String footer() {
		return "default/footer";
	}
}
