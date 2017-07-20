package edu.mum.cs.application.controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by orifjon9 on 7/5/2017.
 */

@RestController
public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {
    	model.addAttribute("msg", "Home page");
        return "<a href=\"/students\">students list</a> <br> <a href=\"/courses\">courses list</a>";
    }

}
