package ntu.edu.vn.nguyenducanh.demojpa.repositories;

import ntu.edu.vn.nguyenducanh.demojpa.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
