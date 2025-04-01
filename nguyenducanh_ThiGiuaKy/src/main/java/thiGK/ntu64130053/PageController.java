package thiGK.ntu64130053;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import thiGK.ntu64130053.model.Page;

import java.util.Arrays;
import java.util.List;

@Controller
public class PageController {

    private final List<Page> pages = Arrays.asList(
            new Page(1, "Dashboard", "dashboard", "Welcome to the dashboard", null),
            new Page(2, "Page - List", "page-list", "List of all pages", null),
            new Page(3, "Page - Add New", "page-add", "Add a new page", null)
    );

    @GetMapping("/page-list")
    public String pageList(ModelMap model) {
        model.addAttribute("pages", pages);
        model.addAttribute("content", "pages/page-list");
        return "FrontEndLayout";
    }

    @GetMapping("/page-add")
    public String pageAdd(ModelMap model) {
        model.addAttribute("content", "pages/page-add");
        return "FrontEndLayout";
    }
    @PostMapping("/page-add")
    public String pageAddNew(@RequestParam String pageName, @RequestParam String keyword, @RequestParam String content) {
        pages.add(new Page(pages.size() + 1, pageName, keyword, content, null));
        return "redirect:/page-list";
    }
}


