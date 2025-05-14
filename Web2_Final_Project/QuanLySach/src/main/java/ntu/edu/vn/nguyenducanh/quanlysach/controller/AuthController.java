package ntu.edu.vn.nguyenducanh.quanlysach.controller;

import ntu.edu.vn.nguyenducanh.quanlysach.model.User;
import ntu.edu.vn.nguyenducanh.quanlysach.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        ModelMap model) {
        Optional<User> user = authService.login(email, password);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "redirect:/index";
        } else {
            model.addAttribute("error", "Sai tên đăng nhập hoặc mật khẩu");
            return "redirect:/login";
        }
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String repeatPassword,
                           ModelMap model) {
        if (!repeatPassword.equals(password)) {
            model.addAttribute("error", "Mật khẩu không khớp");
            return "redirect:/register";
        }

        User user = new User();
        user.setName(username);
        user.setEmail(email);
        user.setPassword(password);

        boolean result = authService.register(user);
        if (result) {
            model.addAttribute("success", "Đăng ký tài khoản thành công");
            return "redirect:/login";
        } else {
            model.addAttribute("error", "Email đã tồn tại");
            return "redirect:/register";
        }
    }
}
