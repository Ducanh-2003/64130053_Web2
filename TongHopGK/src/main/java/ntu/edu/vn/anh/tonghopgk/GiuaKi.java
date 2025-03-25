package ntu.edu.vn.anh.tonghopgk;

import model.StudentModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GiuaKi {
    @GetMapping("/")
    public String giuaKi() {
        return "FrontEndGiuaKi";
    }

    @GetMapping("/about")
    public String about(ModelMap model) {
        model.addAttribute("mssv","64130053");
        model.addAttribute("hoVaTen","Nguyễn Đức Anh");
        model.addAttribute("namSinh","64130053");
        model.addAttribute("gioiTinh","Nam");
        return "layout/About";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        List<StudentModel> students = List.of(
                new StudentModel("64130053", "Nguyễn Đức Anh", 7),
                new StudentModel("64130000", "Nguyễn Thị Thị", 9.9),
                new StudentModel("64131234", "Đỗ Văn Đỗ", 4.5),
                new StudentModel("64130343", "Lại Lai Lai", 8.8)
        );
        model.addAttribute("studentModelList", students);
        return "layout/List";
    }

    @RequestMapping("/addNew")
    public String addNew() {
        return "layout/AddNew";
    }
}
