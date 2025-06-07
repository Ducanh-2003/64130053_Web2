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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password,
                        RedirectAttributes redirectAttributes,HttpSession session) {
        Optional<User> user = authService.login(email, password);
        if (user.isPresent()) {
            session.setAttribute("loggedInUser", user.get());
            session.setAttribute("loggedRole", user.get().getRole());
            redirectAttributes.addFlashAttribute("success",
                    "Đăng nhập thành công!");
            if ("admin".equalsIgnoreCase(user.get().getRole())) {
                return "redirect:/dashboard";
            } else {
                return "redirect:/borrows/user";
            }
        } else {
            redirectAttributes.addFlashAttribute("error",
                    "Sai tên đăng nhập hoặc mật khẩu");
            return "redirect:/login";
        }
    }


    @PostMapping("/register")
    public String register(@RequestParam String name, @RequestParam String email, @RequestParam String password,
                           @RequestParam String confirmPassword, RedirectAttributes redirectAttributes) {
        if (!confirmPassword.equals(password)) {
            redirectAttributes.addFlashAttribute("error",
                    "Mật khẩu không khớp");
            return "redirect:/register";
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole("user");
        boolean result = authService.register(user);
        if (result) {
            redirectAttributes.addFlashAttribute("success",
                    "Đăng ký tài khoản thành công");
            return "redirect:/login";
        } else {
            redirectAttributes.addFlashAttribute("error",
                    "Email đã tồn tại");
            return "redirect:/register";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
