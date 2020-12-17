package com.javayh.advanced.web;

import com.javayh.advanced.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * redis test
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2020-12-17 5:29 PM
 */
@RestController
@RequestMapping(value = "/redis/")
public class RedisApiWeb {
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("test")
    public void redisTest(){
        redisUtil.addStr("redis","Hello World");
        System.out.println(redisUtil.getStr("redis"));
        Map<String,Object> map = new HashMap<>();
        map.put("hash01","hash02");
        redisUtil.setHashTime("myHash",map,100);
        System.out.println(redisUtil.getHashAll("myHash"));
    }

}
