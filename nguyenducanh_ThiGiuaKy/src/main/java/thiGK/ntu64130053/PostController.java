package thiGK.ntu64130053;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import thiGK.ntu64130053.model.Post;

import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {

    private final List<Post> posts = Arrays.asList(
            new Post(1, "Post - List", "Introduction to Spring Boot", 101, "/images/springboot.jpg"),
            new Post(2, "Post - Add New", "How to use Thymeleaf with Spring Boot", 102, "/images/thymeleaf.jpg")
    );

    @GetMapping("/post-list")
    public String postList(ModelMap model) {
        model.addAttribute("posts", posts);
        model.addAttribute("content", "pages/post-list");
        return "FrontEndLayout";
    }

    @GetMapping("/post-add")
    public String pageAdd(ModelMap model) {
        model.addAttribute("content", "pages/post-add");
        return "FrontEndLayout";
    }
    @PostMapping("/post-add")
    public String postAddNew(@RequestParam String title, @RequestParam String content, @RequestParam int categoryId) {
        posts.add(new Post(posts.size() + 1, title, content, categoryId, "/images/default.jpg"));
        return "redirect:/post-list";
    }
}
