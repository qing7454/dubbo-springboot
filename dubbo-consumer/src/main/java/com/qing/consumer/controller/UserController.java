package com.qing.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qing.consumer.UserService;
import com.qing.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Reference(version = "${demo.service.version}",
            application = "${dubbo.application.id}",
            url = "dubbo://127.0.0.1:12345")
    private UserService userService;

    @GetMapping(value = "insert")
    public User insert(User user) {
        return userService.save(user);
    }

    @GetMapping(value = "list")
    public List<User> findList(Integer page, Integer rows) {
        return userService.findList(page, rows);
    }

    @GetMapping(value = "findByName")
    public User findByUsername(String name) {
        return userService.findOneByUsername(name);
    }
}
