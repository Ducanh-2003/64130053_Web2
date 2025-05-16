package ntu.edu.vn.nguyenducanh.quanlysach.controller;

import ntu.edu.vn.nguyenducanh.quanlysach.model.Book;
import ntu.edu.vn.nguyenducanh.quanlysach.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public String getAllBooks(ModelMap model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("bookList", books);
        return "views/BookList";
    }

    @GetMapping("/new")
    public String getNewBookForm(ModelMap model) {
        model.addAttribute("book", new Book());
        return "views/BookCreate";
    }

    @PostMapping("/new")
    public String postNewBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/books/all";
    }

    @GetMapping("/view/{id}")
    public String viewBook(@PathVariable("id") int id, ModelMap model) {
        Optional<Book> bookOpt = bookService.findById(id);
        if (bookOpt.isPresent()) {
            model.addAttribute("bookDetail", bookOpt.get());
            return "views/BookView";
        } else {
            return "redirect:/books/all";
        }
    }

    @GetMapping("/edit/{id}")
    public String getEditBookForm(@PathVariable("id") int id, ModelMap model) {
        Optional<Book> userOpt = bookService.findById(id);
        if (userOpt.isPresent()) {
            model.addAttribute("bookEdit", userOpt.get());
            return "views/BookEdit";
        } else {
            return "redirect:/books/all";
        }
    }

    @PostMapping("/edit/{id}")
    public String postEditBook(@PathVariable("id") int id, @ModelAttribute Book book) {
        Optional<Book> existingBookOpt = bookService.findById(id);
        if (existingBookOpt.isPresent()) {
            Book existingBook = existingBookOpt.get();
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setDescription(book.getDescription());
            existingBook.setQuantity(book.getQuantity());
            existingBook.setCategoryName(book.getCategoryName());
            bookService.save(existingBook);
        }
        return "redirect:/books/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.deleteById(id);
        return "redirect:/books/all";
    }
}
