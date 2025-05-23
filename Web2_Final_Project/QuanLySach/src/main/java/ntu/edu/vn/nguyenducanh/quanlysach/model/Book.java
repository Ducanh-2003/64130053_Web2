package ntu.edu.vn.nguyenducanh.quanlysach.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "book")
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String author;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "book_link")
    private String bookLink;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Borrow> borrows;
}
