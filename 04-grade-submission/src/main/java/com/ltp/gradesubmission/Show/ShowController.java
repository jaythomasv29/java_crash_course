package com.ltp.gradesubmission.Show;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowController {

    @GetMapping("/shows")
    public String getShows(Model model) {
        model.addAttribute("s1", new Show("Breaking Bad", "Ozy", 10.0));
        model.addAttribute("s2", new Show("Attack on Titan", "Hero", 5.0));
        model.addAttribute("s3", new Show("Attack on Titan", "Perfect Game", 9.9));
        model.addAttribute("s4", new Show("Star Wars", "Victory and Death", 5.7));
        model.addAttribute("s5", new Show("Mr. Robot", "Hack Wars", 6.7));
        model.addAttribute("expense", 50);
        model.addAttribute("furniture", "robot");
        return "shows";
    }
}