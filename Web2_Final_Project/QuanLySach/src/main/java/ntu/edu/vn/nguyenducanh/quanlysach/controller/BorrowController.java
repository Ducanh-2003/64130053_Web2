package ntu.edu.vn.nguyenducanh.quanlysach.controller;

import jakarta.servlet.http.HttpSession;
import ntu.edu.vn.nguyenducanh.quanlysach.model.Book;
import ntu.edu.vn.nguyenducanh.quanlysach.model.Borrow;
import ntu.edu.vn.nguyenducanh.quanlysach.model.User;
import ntu.edu.vn.nguyenducanh.quanlysach.service.BookService;
import ntu.edu.vn.nguyenducanh.quanlysach.service.BorrowService;
import ntu.edu.vn.nguyenducanh.quanlysach.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
        return "views/BorrowListForAdmin";
    }

    @GetMapping("/user")
    public String showBookList(ModelMap model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);
        return "views/BookListForUser";
    }

    @GetMapping("/borrow")
    public String borrowBook(@RequestParam("bookId") int bookId, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/login";
        }

        Optional<Book> bookOpt = bookService.findById(bookId);
        if (bookOpt.isPresent()) {
            Borrow borrow = new Borrow();
            borrow.setBook(bookOpt.get());
            borrow.setUser(loggedInUser);
            borrow.setStatus("pending");
            borrow.setBorrowDate(java.time.LocalDate.now());
            borrowService.save(borrow);
        }

        return "redirect:/borrows/user?success=true";
    }

    @GetMapping("/borrowed")
    public String viewBorrowedBooks(HttpSession session, Model model) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/login";
        }

        List<Borrow> borrowedList = borrowService.findByUser(loggedInUser);
        model.addAttribute("borrowedList", borrowedList);

        return "views/BorrowedList";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam("borrowId") int borrowId, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        Optional<Borrow> borrowOpt = borrowService.findById(borrowId);
        if (borrowOpt.isPresent()) {
            Borrow borrow = borrowOpt.get();
            if (borrow.getUser().getId() == loggedInUser.getId()) {
                borrow.setReturnDate(LocalDate.now());
                borrow.setStatus("returned");
                borrowService.save(borrow);
            }
        }

        return "redirect:/borrows/borrowed";
    }


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

}
