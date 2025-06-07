package ntu.edu.vn.nguyenducanh.quanlysach.service;

import ntu.edu.vn.nguyenducanh.quanlysach.model.Book;
import ntu.edu.vn.nguyenducanh.quanlysach.repository.BookRepository;
import ntu.edu.vn.nguyenducanh.quanlysach.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowRepository borrowRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    public Page<Book> searchByTitle(String keyword, Pageable pageable) {
        return bookRepository.findByTitle(keyword, pageable);
    }

    public Optional<Book> findById(int id) {
        return bookRepository.findById(id);
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }
}
