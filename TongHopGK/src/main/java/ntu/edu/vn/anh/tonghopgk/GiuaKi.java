package ntu.edu.vn.anh.tonghopgk;

import model.StudentModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GiuaKi {

    private final List<StudentModel> students = new ArrayList<>();

    public GiuaKi() {
        students.add(new StudentModel("64130053", "Nguyễn Đức Anh", 7));
        students.add(new StudentModel("64130000", "Nguyễn Thị Thị", 9.9));
        students.add(new StudentModel("64131234", "Đỗ Văn Đỗ", 4.5));
        students.add(new StudentModel("64130343", "Lại Lai Lai", 8.8));
    }

    @GetMapping("/")
    public String giuaKi(@RequestParam(name = "page", defaultValue = "home") String page, Model model) {
        model.addAttribute("page", page);

        if (page.equals("about")) {
            model.addAttribute("mssv", "64130053");
            model.addAttribute("hoVaTen", "Nguyễn Đức Anh");
            model.addAttribute("namSinh", "2003");
            model.addAttribute("gioiTinh", "Nam");
        } else if (page.equals("list")) {
            model.addAttribute("studentModelList", students);
        }
        return "FrontEndGiuaKi";
    }

    @GetMapping("/add")
    public String showAddPage(Model model) {
        model.addAttribute("student", new StudentModel());
        return "FrontEndGiuaKi";
    }

    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute StudentModel student) {
        students.add(student);
        return "redirect:/?page=list";
    }
}
