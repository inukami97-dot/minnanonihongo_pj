package com.example.minnanonihongo_test_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    // Hiển thị form login
    @GetMapping("/login")
    public String login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            Model model) {

        if (error != null) {
            // Thông báo lỗi login
            model.addAttribute("errorMsg", "Tên đăng nhập hoặc mật khẩu không đúng");
        }

        if (logout != null) {
            // Thông báo logout thành công
            model.addAttribute("msg", "Bạn đã đăng xuất thành công");
        }

        return "login"; // trả về file login.html trong templates
    }

    // Trang chủ sau khi login thành công
    @GetMapping({"/", "/index"})
    public String index() {
        return "index"; // trả về index.html
    }
}
