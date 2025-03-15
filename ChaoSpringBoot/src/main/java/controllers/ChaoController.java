package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChaoController {
    @GetMapping("/chao")
    public String xinChao(){
        return "chao";
    }

    @RequestMapping("/ayo")
    public String ayo(ModelMap model){
        model.addAttribute("ayo","Xin Chao, test model map");
        return "ayo";
    }
}
