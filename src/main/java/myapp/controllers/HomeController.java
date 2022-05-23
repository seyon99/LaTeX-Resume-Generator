package myapp.controllers;

import myapp.controllers.LatexMicroservice.LatexController;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/createheader")
    // Create data object for request body later
    public String newHeader(@RequestParam String name){
        LatexController ctrl = new LatexController();
        String head = ctrl.generateHeader(name, "88 Highhill", "111-111-1111", "abc@gmail.com",
                "seyon-k", "seyon99", "www.seyonk.me");
        return head;
    }
}
