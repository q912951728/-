package com.example.seckill.controller;

import com.example.seckill.pojo.User;
import com.example.seckill.service.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IUserService userService;

    // 跳转商品列表页
    @RequestMapping("/toList")
    public String goodsList(HttpServletRequest request, HttpServletResponse response, Model model, @CookieValue("userTicket") String ticket) {
        if(ticket == null || ticket.isEmpty()){
            return "login";
        }
        //User user = (User) session.getAttribute(ticket);
        User user = userService.getUserByCookie(ticket, request, response);
        if (user == null){
            return "login";
        }
        model.addAttribute("user",user);
        return "goodsList";
    }
}
