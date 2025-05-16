package ntu.edu.vn.nguyenducanh.quanlysach.controller;

import jakarta.servlet.http.HttpSession;
import ntu.edu.vn.nguyenducanh.quanlysach.model.Borrow;
import ntu.edu.vn.nguyenducanh.quanlysach.model.User;
import ntu.edu.vn.nguyenducanh.quanlysach.service.BookService;
import ntu.edu.vn.nguyenducanh.quanlysach.service.BorrowService;
import ntu.edu.vn.nguyenducanh.quanlysach.service.AuthService;
import ntu.edu.vn.nguyenducanh.quanlysach.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/borrows")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String getAllBorrows(ModelMap model) {
        List<Borrow> borrowList = borrowService.findAll();
        model.addAttribute("borrowList", borrowList);
        return "views/BorrowListAdmin";
    }

    @GetMapping("/my")
    public String getMyBorrows(HttpSession session, ModelMap model) {
        User currentUser = (User) session.getAttribute("loggedInUser");
        if (currentUser == null) {
            return "redirect:/login";
        }

        List<Borrow> borrows = borrowService.findByUser(currentUser);
        model.addAttribute("borrowList", borrows);
        return "views/borrow/BorrowListUser";
    }

}
