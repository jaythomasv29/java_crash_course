package com.ltp.gradesubmission.Grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

// controller annotation
// entry point for web requests through GET / POST
@Controller
public class GradeController {
//    @Autowired
    GradeService gradeService;
//    @Autowired (This line is the same as constructor injection below)
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }


    // handler to map a path for GET requests at a specific endpoint
    // responds to get requests @ "/"
    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("name", "James");
        return "index";
    }

    // handler to map a path for GET requests at a specific endpoint
    // responds to get requests @ "/grades"
    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", gradeService.getGrades());
        return "grades";
    }

    // Handler that accepts GET request: "/add"
    @GetMapping("/add")
    public String getForm(Model model) {
        model.addAttribute("grade", new Grade());
        return "form";
    }

    // Handler that accepts POST request: "/add"
    @PostMapping("/addGrade")
    public String submitForm(@Valid Grade grade, BindingResult result) {
        if(result.hasErrors()) return "form";
        gradeService.submitGrade(grade);
        return "redirect:/grades";
    }


    @GetMapping("/editStudent")
    public String editStudent(Model model, @RequestParam(required = false) String id) {
        int foundIndex = gradeService.getStudentIdxById(id);
//        System.out.println(getStudentGradeById(name));
        if (foundIndex == -1) {
            model.addAttribute("grade", new Grade());
        } else {
            model.addAttribute("grade", gradeService.getGrade(foundIndex));
        }
            return "form";
    }

    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam(required = true) String id) {
        int foundIndex = gradeService.getStudentIdxById(id);
        gradeService.deleteGrade(foundIndex);
        return "redirect:/grades";
    }
}
