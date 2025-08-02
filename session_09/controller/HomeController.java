package com.data.session_09.controller;

import com.data.session_09.model.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String showHome(HttpSession session) {
        // Kiểm tra người dùng đã đăng nhập chưa
        User user = (User) session.getAttribute("loginUser");
        if (user == null) {
            return "redirect:/auth/login";
        }
        return "home";
    }
}
