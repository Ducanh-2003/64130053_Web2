package ntu.edu.vn.nguyenducanh.quanlysach.service;

import ntu.edu.vn.nguyenducanh.quanlysach.model.User;

import java.util.Optional;

public interface AuthService {
    Optional<User> login(String email, String password);
    boolean register(User user);

}

