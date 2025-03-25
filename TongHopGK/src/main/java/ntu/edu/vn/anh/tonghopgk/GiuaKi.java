package ntu.edu.vn.anh.tonghopgk;

import model.StudentModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GiuaKi {
    @GetMapping("/")
    public String giuaKi(@RequestParam(name = "page", defaultValue = "home") String page, ModelMap model) {
        model.addAttribute("page", page);

        if (page.equals("about")) {
            model.addAttribute("mssv", "64130053");
            model.addAttribute("hoVaTen", "Nguyễn Đức Anh");
            model.addAttribute("namSinh", "2003");
            model.addAttribute("gioiTinh", "Nam");
        } else if (page.equals("list")) {
            List<StudentModel> students = List.of(
                    new StudentModel("64130053", "Nguyễn Đức Anh", 7),
                    new StudentModel("64130000", "Nguyễn Thị Thị", 9.9),
                    new StudentModel("64131234", "Đỗ Văn Đỗ", 4.5),
                    new StudentModel("64130343", "Lại Lai Lai", 8.8)
            );
            model.addAttribute("studentModelList", students);
        }  else if (page.equals("addNew")) {



        }
        return "FrontEndGiuaKi";
    }
}
