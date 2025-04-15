package ntu.edu.vn.anh.nguyenducanh_thigiuaky_2nd.models;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {
    private String id;
    private String title;
    private String content;
    private String categoryId;

    public Post() {}

    public Post(String id, String title, String content, String categoryId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.categoryId = categoryId;
    }
}