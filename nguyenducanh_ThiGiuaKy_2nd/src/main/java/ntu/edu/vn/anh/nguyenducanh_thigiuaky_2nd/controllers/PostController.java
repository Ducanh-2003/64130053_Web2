package ntu.edu.vn.anh.nguyenducanh_thigiuaky_2nd.controllers;

import ntu.edu.vn.anh.nguyenducanh_thigiuaky_2nd.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
@Controller
public class PostController {
    private final List<Post> posts = new ArrayList<>();

    public PostController() {
        posts.add(new Post("1", "Introduction to Java", "This is an introductory post about Java.", "1"));
        posts.add(new Post("2", "Spring Framework Basics", "Learn the basics of Spring Framework.", "2"));
        posts.add(new Post("3", "Understanding Hibernate", "This post covers the basics of Hibernate ORM.", "2"));
        posts.add(new Post("4", "Getting Started with JavaScript", "Beginner guide to JavaScript programming.", "3"));
        posts.add(new Post("5", "Introduction to Web Development", "A guide to getting started with web development.", "3"));
    }

    @GetMapping("/post/all")
    public String getAllPost(ModelMap model) {
        model.addAttribute("postList", posts);
        return "view/PostList";
    }

    @GetMapping("/post/new")
    public String getNewPost(ModelMap model) {
        model.addAttribute("post", new Post());
        return "view/PostNew";
    }

    @PostMapping("/post/new")
    public String postNewPost(@ModelAttribute Post post) {
        posts.add(post);
        return "redirect:/post/all";
    }

    @GetMapping("/post/view/{id}")
    public String getPostById(@PathVariable String id, ModelMap model) {
        Post getIdPost = posts.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
        model.addAttribute("getIdView", getIdPost);
        return "view/PostView";
    }
}
