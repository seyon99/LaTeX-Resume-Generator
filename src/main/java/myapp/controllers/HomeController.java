package myapp.controllers;

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
    public String newHeader(@RequestParam String name){
        return "Hello, my name is " + name +", nice to meet you!";
    }
}
