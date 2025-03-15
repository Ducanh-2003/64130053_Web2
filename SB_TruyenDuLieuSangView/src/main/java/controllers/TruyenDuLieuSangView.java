package controllers;

import jakarta.servlet.http.HttpServletRequest;
import models.StudentModel;
import models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TruyenDuLieuSangView {

    private static final String ID = "64130053";
    private static final String PW = "ducanh123";

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


    @RequestMapping("/login")
    public String login(HttpServletRequest request, ModelMap model) throws ParseException {
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        if(ID.equals(id) && PW.equals(pw)) {
            Date dob = new SimpleDateFormat("yyyy-MM-dd").parse("2003-20-03");
            User user = new User(id, "NGUYỄN ĐỨC ANH", true, dob);
            model.addAttribute("uInfo", user);
            return "UserLogin";
        }
        else{
            return "Login";
        }

    }

}
