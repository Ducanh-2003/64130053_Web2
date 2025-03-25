package ntu.edu.vn.anh.tonghopgk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GiuaKi {
    @GetMapping("/")
    public String giuaKi() {
        return "FrontEndGiuaKi";
    }

    @GetMapping("/about")
    public String about() {
        return "layout/About";
    }

    @GetMapping("/list")
    public String list() {
        return "layout/List";
    }

    @RequestMapping("/addNew")
    public String addNew() {
        return "layout/AddNew";
    }
}
