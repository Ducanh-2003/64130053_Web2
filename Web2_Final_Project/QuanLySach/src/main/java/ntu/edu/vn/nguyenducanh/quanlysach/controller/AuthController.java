package ntu.edu.vn.nguyenducanh.quanlysach.controller;

import jakarta.servlet.http.HttpSession;
import ntu.edu.vn.nguyenducanh.quanlysach.model.User;
import ntu.edu.vn.nguyenducanh.quanlysach.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
                        ModelMap model,
                        HttpSession session) {
        Optional<User> user = authService.login(email, password);
        if (user.isPresent()) {
            session.setAttribute("loggedInUser", user.get());
            if ("admin".equalsIgnoreCase(user.get().getRole())) {
                model.addAttribute("success", "Đăng nhập thành công!");
                return "views/DashBoard";
            } else {
                model.addAttribute("success", "Đăng nhập thành công!");
                return "views/BookListForUser";
            }
        } else {
            model.addAttribute("error", "Sai tên đăng nhập hoặc mật khẩu");
            return "login";
        }
    }

    @PostMapping("/register")
    public String register(@RequestParam String name,
                           @RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String confirmPassword,
                           ModelMap model) {
        if (!confirmPassword.equals(password)) {
            model.addAttribute("error", "Mật khẩu không khớp");
            return "register";
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole("user");

        boolean result = authService.register(user);
        if (result) {
            model.addAttribute("success", "Đăng ký tài khoản thành công");
            return "login";
        } else {
            model.addAttribute("error", "Email đã tồn tại");
            return "register";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
