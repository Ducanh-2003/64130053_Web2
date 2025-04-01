package thiGK.ntu64130053.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import thiGK.ntu64130053.model.Page;
import thiGK.ntu64130053.model.Post;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    private final List<Page> pages = Arrays.asList(
            new Page(1, "Dashboard", "dashboard", "Welcome to the dashboard", null),
            new Page(2, "Page - List", "page-list", "List of all pages", null),
            new Page(3, "Page - Add New", "page-add", "Add a new page", null)
    );

    private final List<Post> posts = Arrays.asList(
            new Post(1, "Post - List", "Introduction to Spring Boot", 101, "/images/springboot.jpg"),
            new Post(2, "Post - Add New", "How to use Thymeleaf with Spring Boot", 102, "/images/thymeleaf.jpg")
    );

    @GetMapping("/")
    public String home(ModelMap model) {
        model.addAttribute("username", "Nguyễn Đức Anh");
        model.addAttribute("pages", pages);
        model.addAttribute("posts", posts);
        model.addAttribute("content", "pages/dashboard");
        return "FrontEndLayout";
    }
}
