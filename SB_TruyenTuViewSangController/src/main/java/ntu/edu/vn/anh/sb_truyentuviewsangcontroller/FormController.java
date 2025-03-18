package ntu.edu.vn.anh.sb_truyentuviewsangcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
    @GetMapping("/form")
    public String showForm() {
        return "form";
    }

    // Nhận dữ liệu từ form (method POST)
    @PostMapping("/submit")
    public String submitForm(@RequestParam("name") String name, ModelMap model) {
        model.addAttribute("greeting", "Hello, " + name + "!");
        return "form";  // Hiển thị lại form cùng với lời chào
    }
}
