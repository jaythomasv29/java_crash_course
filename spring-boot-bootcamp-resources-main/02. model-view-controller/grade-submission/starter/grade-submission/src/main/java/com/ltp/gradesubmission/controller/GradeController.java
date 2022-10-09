package com.ltp.gradesubmission.controller;

import com.ltp.gradesubmission.Grade;
import com.ltp.gradesubmission.GradeSubmissionApplication;
import com.ltp.gradesubmission.repository.GradeRepository;
import com.ltp.gradesubmission.service.GradeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

// controller annotation
// entry point for web requests through GET / POST
@Controller
public class GradeController {
    GradeService gradeService = new GradeService();

    // handler to map a path for GET requests at a specific endpoint
    // responds to get requests @ "/"
    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("name", "James");
        return "index";
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
    // handler to map a path for GET requests at a specific endpoint
    // responds to get requests @ "/grades"
    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", gradeService.getGrades());
        return "grades";
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
}
