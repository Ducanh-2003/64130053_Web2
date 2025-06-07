package ntu.edu.vn.nguyenducanh.quanlysach.service;

import ntu.edu.vn.nguyenducanh.quanlysach.model.Book;
import ntu.edu.vn.nguyenducanh.quanlysach.model.Borrow;
import ntu.edu.vn.nguyenducanh.quanlysach.model.User;
import ntu.edu.vn.nguyenducanh.quanlysach.repository.BookRepository;
import ntu.edu.vn.nguyenducanh.quanlysach.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Borrow> findAll() {
        return borrowRepository.findAll();
    }

    public List<Borrow> findByUser(User user) {
        return borrowRepository.findByUser(user);
    }

    public Page<Borrow> findAll(Pageable pageable) {
        return borrowRepository.findAll(pageable);
    }

    public Optional<Borrow> findById(int id) {
        return borrowRepository.findById(id);
    }

    public boolean existsByUserAndBook(User user, Book book) {
        return borrowRepository.existsByUserAndBook(user, book);
    }

    public void save(Borrow borrow) {
        borrowRepository.save(borrow);
    }
}
