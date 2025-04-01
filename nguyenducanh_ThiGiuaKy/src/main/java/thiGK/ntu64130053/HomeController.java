package thiGK.ntu64130053;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(ModelMap model) {
        model.addAttribute("username", "Nguyễn Đức Anh");
        return "FrontEndLayout";
    }
}
