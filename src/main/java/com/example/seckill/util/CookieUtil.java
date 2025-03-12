package com.example.seckill.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieUtil {

    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String ticket) {
        // 设置Cookie
        Cookie cookie = new Cookie(cookieName, ticket);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setMaxAge(60 * 60 * 24 * 7);
        response.addCookie(cookie);

    }

    public static Cookie getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }

    public static void deleteCookie(HttpServletResponse response, String name) {
        Cookie cookie = new Cookie(name, null);
        cookie.setPath("/");
        cookie.setMaxAge(0); // 设置最大年龄为0，表示立即删除
        response.addCookie(cookie);
    }

    // 新增方法：设置session
    public static void setSessionCookie(HttpServletResponse response, String sessionId) {
        Cookie sessionCookie = new Cookie("JSESSIONID", sessionId);
        sessionCookie.setPath("/");
        sessionCookie.setHttpOnly(true);
        sessionCookie.setSecure(false);
        sessionCookie.setMaxAge(60 * 60 * 24 * 7); // 7天
        response.addCookie(sessionCookie);
    }
}