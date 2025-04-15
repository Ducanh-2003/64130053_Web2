package ntu.edu.vn.anh.nguyenducanh_thigiuaky_2nd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String dashBoard(ModelMap model) {
        model.addAttribute("mssv", "64130053");
        model.addAttribute("hoVaTen", "Nguyễn Đức Anh");
        model.addAttribute("namSinh", "64130053");
        model.addAttribute("gioiTinh", "Male");
        return "Dashboard";
    }

}