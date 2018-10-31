package com.qing.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qing.consumer.StudentService;
import com.qing.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoConsumerController {

    @Reference(version = "${demo.service.version}",
            application = "${dubbo.application.id}",
            url = "dubbo://127.0.0.1:12345")
    private DemoService demoService;

    @Reference(version = "${demo.service.version}",
            application = "${dubbo.application.id}",
            url = "dubbo://127.0.0.1:12345")
    private StudentService studentService;

    @GetMapping("/sayHello")
    public String sayHello(@RequestParam String name) {
        return demoService.sayHello(name);
    }

    @GetMapping("/student")
    public String student(@RequestParam String first, String last) {
        return studentService.foo(first, last);
    }
}
