package ntu.edu.vn.nguyenducanh.quanlysach.service;

import ntu.edu.vn.nguyenducanh.quanlysach.model.Borrow;
import ntu.edu.vn.nguyenducanh.quanlysach.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowService {
    @Autowired
    private BorrowRepository borrowRepository;

    public List<Borrow> findAll() {
        return borrowRepository.findAll();
    }

    public void saveBorrow(Borrow borrow) {
        borrow.setStatus("Đang mượn");
        borrow.setBorrowDate(LocalDate.now());
        borrowRepository.save(borrow);
    }

    public Borrow getBorrowById(int id) {
        return borrowRepository.findById(id).orElse(null);
    }

    public void markAsReturned(int id) {
        Borrow borrow = borrowRepository.findById(id).orElse(null);
        if (borrow != null) {
            borrow.setStatus("Đã trả");
            borrow.setReturnDate(LocalDate.now());
            borrowRepository.save(borrow);
        }
    }
}
