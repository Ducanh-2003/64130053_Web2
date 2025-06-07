package ntu.edu.vn.nguyenducanh.quanlysach.service;

import ntu.edu.vn.nguyenducanh.quanlysach.model.User;
import ntu.edu.vn.nguyenducanh.quanlysach.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> login(String email, String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (user.getPassword().equals(password)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public boolean register(User user) {
        if (userRepository.findByName(user.getName().trim()).isPresent() ||
                userRepository.findByEmail(user.getEmail().trim()).isPresent()) {
            return false;
        }
        userRepository.save(user);
        return true;
    }
}
