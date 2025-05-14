package ntu.edu.vn.nguyenducanh.quanlysach.controller;

import ntu.edu.vn.nguyenducanh.quanlysach.model.Borrow;
import ntu.edu.vn.nguyenducanh.quanlysach.service.BookService;
import ntu.edu.vn.nguyenducanh.quanlysach.service.BorrowService;
import ntu.edu.vn.nguyenducanh.quanlysach.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/borrows")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @Autowired
    private AuthService authService;

    @Autowired
    private BookService bookService;

    @GetMapping
    public String listBorrows(Model model) {
        model.addAttribute("borrows", borrowService.findAll());
        return "borrow/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("borrow", new Borrow());
//        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("books", bookService.findAll());
        return "borrow/create";
    }

    @PostMapping("/create")
    public String createBorrow(@ModelAttribute Borrow borrow) {
        borrowService.saveBorrow(borrow);
        return "redirect:/borrows";
    }

    @GetMapping("/return/{id}")
    public String returnBook(@PathVariable int id) {
        borrowService.markAsReturned(id);
        return "redirect:/borrows";
    }
}
