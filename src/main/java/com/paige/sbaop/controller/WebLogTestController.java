package com.paige.sbaop.controller;

import com.paige.sbaop.annotation.ControllerWebLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Web日志测试相关接口
 * @author paige
 * @create 2020-12-15 22:38
 */
@RestController
@RequestMapping("/weblog")
public class WebLogTestController {

    @GetMapping("/get-test")
    @ControllerWebLog(name = "GET请求测试接口")
    public String hello(@RequestParam("name") String name) {
        return name;
    }
}