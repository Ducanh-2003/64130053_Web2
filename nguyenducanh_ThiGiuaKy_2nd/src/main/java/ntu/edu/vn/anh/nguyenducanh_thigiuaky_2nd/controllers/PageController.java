package ntu.edu.vn.anh.nguyenducanh_thigiuaky_2nd.controllers;

import ntu.edu.vn.anh.nguyenducanh_thigiuaky_2nd.models.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
@Controller
public class PageController {
    private final List<Page> pages = new ArrayList<>();

    public PageController() {
        pages.add(new Page("1", "Home", "home, main", "Welcome to the homepage", "0"));
        pages.add(new Page("2", "About", "about, information", "About the website", "1"));
        pages.add(new Page("3", "Contact", "contact, support", "Contact us for more information", "1"));
        pages.add(new Page("4", "Products", "products, items", "Browse our product catalog", "1"));
        pages.add(new Page("5", "Services", "services, offerings", "Explore our services", "1"));
        pages.add(new Page("6", "FAQ", "faq, questions", "Frequently asked questions", "1"));
    }


    @GetMapping("/page/all")
    public String getAllPage(ModelMap model) {
        model.addAttribute("pageList", pages);
        return "view/PageList";
    }

    @GetMapping("/page/new")
    public String getNewPage(ModelMap model) {
        model.addAttribute("page", new Page());
        return "view/PageNew";
    }

    @PostMapping("/page/new")
    public String postNewPage(@ModelAttribute Page page) {
        pages.add(page);
        return "redirect:/page/all";
    }

    @GetMapping("/page/view/{id}")
    public String getPageById(@PathVariable String id, ModelMap model) {
        Page getIdPage = pages.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
        model.addAttribute("getIdView", getIdPage);
        return "view/PageView";
    }

    @GetMapping("/page/edit/{id}")
    public String getEditPage(@PathVariable String id, ModelMap model) {
        Page getIdPage = pages.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
        model.addAttribute("getIdEdit", getIdPage);
        return "view/PageEdit";
    }

    @PostMapping("/page/edit/{id}")
    public String postEditPage(@PathVariable String id, @ModelAttribute Page page) {
        Page getIdPage = pages.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (getIdPage != null) {
            getIdPage.setPageName(page.getPageName());
            getIdPage.setKeyword(page.getKeyword());
            getIdPage.setContent(page.getContent());
            getIdPage.setParentPageId(page.getParentPageId());
        }
        return "redirect:/page/all";
    }



}
