package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TruyenDuLieuSangView {
    @RequestMapping("/truyendulieu")
    public String truyenDuLieu(ModelMap model) {
        model.addAttribute("mssv","64130053");
        model.addAttribute("hoVaTen","Nguyễn Đức Anh");
        model.addAttribute("namSinh","64130053");
        model.addAttribute("gioiTinh","Nam");
        return "View";
    }
}
