package ntu.edu.vn.nguyenducanh.quanlysach.controller;

import jakarta.servlet.http.HttpSession;
import ntu.edu.vn.nguyenducanh.quanlysach.model.Book;
import ntu.edu.vn.nguyenducanh.quanlysach.model.Borrow;
import ntu.edu.vn.nguyenducanh.quanlysach.model.User;
import ntu.edu.vn.nguyenducanh.quanlysach.service.BookService;
import ntu.edu.vn.nguyenducanh.quanlysach.service.BorrowService;
import ntu.edu.vn.nguyenducanh.quanlysach.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    //Admin
    @GetMapping("/admin")
    public String getAllBorrowsPaged(
            ModelMap model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Borrow> borrowPage = borrowService.findAll(pageable);
        model.addAttribute("borrowPage", borrowPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);

        return "views/BorrowListForAdmin";
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

    //User
    @GetMapping("/user")
    public String showBookList(ModelMap model,
                               @RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "8") int size,
                               @RequestParam(required = false) String keyword) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> bookPage;
        if (keyword != null && !keyword.trim().isEmpty()) {
            bookPage = bookService.searchByTitle(keyword, pageable);
            model.addAttribute("keyword", keyword);
        } else {
            bookPage = bookService.findAll(pageable);
        }
        model.addAttribute("bookPage", bookPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);
        return "views/BookListForUser";
    }

    @GetMapping("/borrow")
    public String borrowBook(@RequestParam("bookId") int bookId, HttpSession session,
                             RedirectAttributes redirectAttributes) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/login";
        }
        Optional<Book> bookOpt = bookService.findById(bookId);
        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            Borrow borrow = new Borrow();
            boolean alreadyBorrowed = borrowService.existsByUserAndBook(loggedInUser, book);
            if (alreadyBorrowed) {
                redirectAttributes.addFlashAttribute("error",
                        "Bạn đã mượn sách này rồi!");
                return "redirect:/borrows/user";
            }
            borrow.setBook(bookOpt.get());
            borrow.setUser(loggedInUser);
            borrow.setStatus("pending");
            borrow.setBorrowDate(java.time.LocalDate.now());
            borrowService.save(borrow);
            redirectAttributes.addFlashAttribute("success",
                    "Mượn sách thành công!");
        }
        return "redirect:/borrows/user";
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

}
