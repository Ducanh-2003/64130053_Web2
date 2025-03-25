package ntu.edu.vn.anh.tonghopgk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GiuaKi {
    @GetMapping("/")
    public String giuaKi() {
        return "FrontEndGiuaKi";
    }
}
