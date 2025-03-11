package controllers;

import models.StudentModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

    @GetMapping("/truyendsObject")
    public String truyenDsObject(ModelMap model) {
        List<StudentModel> studentModelList = List.of(
                new StudentModel("64130053", "Nguyễn Đức Anh", true, "20/03/2003"),
                new StudentModel("64130000", "Nguyễn Thị Thị", false, "01/01/2001"),
                new StudentModel("64131234", "Đỗ Văn Đỗ", true, "03/03/2005"),
                new StudentModel("64130343", "Lại Lai Lai", false, "04/04/2004")
        );

        model.addAttribute("studentModelList", studentModelList);
        return "ListView";
    }

}
