package com.care.boot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired   
    private RedisService redisService;

    @GetMapping("/save")
    public void save(@RequestParam String key, @RequestParam String value) {
    	System.out.println("save 키 : " + key);
    	System.out.println("save 값 : " + value);
        redisService.save(key, value);
    }

    @GetMapping("/get")
    public String get(@RequestParam String key) {
    	System.out.println("get value: " + redisService.getValue(key));
        return redisService.getValue(key);
    }
    
    @GetMapping("/delete")
    public void delete(@RequestParam String key) {
    	System.out.println("delete key: " + key);
        redisService.delete(key);
    }
}
