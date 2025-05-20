package ntu.edu.vn.nguyenducanh.quanlysach.controller;

import jakarta.servlet.http.HttpSession;
import ntu.edu.vn.nguyenducanh.quanlysach.model.Book;
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

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/borrows")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String getAllBorrows(ModelMap model) {
        List<Borrow> borrowList = borrowService.findAll();
        model.addAttribute("borrowList", borrowList);
        return "views/BorrowListAdmin";
    }

    @GetMapping("/user")
    public String showBookList(ModelMap model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);
        return "views/BookListForUser";
    }

//    @GetMapping("/borrow")
//    public String borrowBook(@RequestParam("bookId") int bookId, Principal principal) {
//        String username = principal.getName();
//        User user = userService.findByName(username);
//
//        // Lấy sách theo ID
//        Optional<Book> bookOpt = bookService.findById(bookId);
//        if (bookOpt.isPresent()) {
//            Borrow borrow = new Borrow();
//            borrow.setBook(bookOpt.get());
//            borrow.setUser(user);
//            borrow.setStatus("pending");
//            borrowService.save(borrow);
//        }
//
//        return "redirect:/borrows/user";
//    }


    @GetMapping("/approve/{id}")
    public String approveBorrow(@PathVariable("id") int id) {
        Optional<Borrow> borrowOpt = borrowService.findById(id);
        if (borrowOpt.isPresent()) {
            Borrow borrow = borrowOpt.get();
            borrow.setStatus("approved");
            borrowService.save(borrow);
        }
        return "redirect:/borrows/admin";
    }

    @GetMapping("/reject/{id}")
    public String rejectBorrow(@PathVariable("id") int id) {
        Optional<Borrow> borrowOpt = borrowService.findById(id);
        if (borrowOpt.isPresent()) {
            Borrow borrow = borrowOpt.get();
            borrow.setStatus("pending");
            borrowService.save(borrow);
        }
        return "redirect:/borrows/admin";
    }

}
