package com.data.session_09.controller;

import com.data.session_09.model.entity.User;
import com.data.session_09.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private IUserService userService;

    // Hiển thị form login
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    // Xử lý login
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {
        User user = userService.login(username, password);
        if (user != null) {
            session.setAttribute("loginUser", user);
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Sai tên đăng nhập hoặc mật khẩu");
            return "login";
        }
    }

    // Hiển thị form register
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // Xử lý form register
    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user,
                           @RequestParam String confirmPassword,
                           Model model) {
        if (!user.getPassword().equals(confirmPassword)) {
            model.addAttribute("error", "Mật khẩu nhập lại không chính xác");
            return "register";
        }

        // Check trùng username
        if (userService.login(user.getUsername(), user.getPassword()) != null) {
            model.addAttribute("error", "Tài khoản đã tồn tại");
            return "register";
        }

        userService.register(user);
        model.addAttribute("message", "Đăng ký thành công!");
        return "login";
    }
}
