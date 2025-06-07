package ntu.edu.vn.nguyenducanh.quanlysach.service;

import ntu.edu.vn.nguyenducanh.quanlysach.model.User;
import ntu.edu.vn.nguyenducanh.quanlysach.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
