package ntu.edu.vn.nguyenducanh.demojpa.models;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    public Student() {

    }
    public Student(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
