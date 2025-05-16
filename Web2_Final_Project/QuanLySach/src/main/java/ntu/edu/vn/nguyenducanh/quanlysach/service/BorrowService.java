package ntu.edu.vn.nguyenducanh.quanlysach.service;

import ntu.edu.vn.nguyenducanh.quanlysach.model.Borrow;
import ntu.edu.vn.nguyenducanh.quanlysach.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BorrowService {
    List<Borrow> findAll();
    List<Borrow> findByUser(User user);
    Optional<Borrow> findById(int id);
    void save(Borrow borrow);
    void deleteById(int id);
}
