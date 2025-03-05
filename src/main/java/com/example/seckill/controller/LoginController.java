package com.example.seckill.controller;

import com.example.seckill.pojo.User;
import com.example.seckill.service.IUserService;
import com.example.seckill.vo.LoginVo;
import com.example.seckill.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Autowired
    private IUserService userService;

    /**
     * 跳转登录页
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "tologin";
    }

    /**
     * 登录
     * @param loginVo
     * @return
     */
    @PostMapping("/doLogin")
    @ResponseBody
    public RespBean doLogin(@RequestBody LoginVo loginVo) {
        log.info("{}", loginVo);
        return userService.doLogin(loginVo);
    }
}