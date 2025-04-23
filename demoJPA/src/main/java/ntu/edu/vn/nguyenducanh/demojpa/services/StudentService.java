package ntu.edu.vn.nguyenducanh.demojpa.services;

import ntu.edu.vn.nguyenducanh.demojpa.models.Student;
import ntu.edu.vn.nguyenducanh.demojpa.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

}
