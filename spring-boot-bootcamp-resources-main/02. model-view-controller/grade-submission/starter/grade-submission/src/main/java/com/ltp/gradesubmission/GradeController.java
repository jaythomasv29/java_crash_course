package com.ltp.gradesubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

// controller annotation
// entry point for web requests through GET / POST
@Controller
public class GradeController {
    List<Grade> studentGrades = new ArrayList<Grade>(Arrays.asList(
        new Grade("Harry", "Science", "D+"),
        new Grade("James", "Sleeping", "C+"),
        new Grade("Nat", "Coding", "A+"),
        new Grade("Miley", "Fitness", "B+")
    ));


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
//        System.out.println(new Grade());
        return "form";
    }

    // Handler that accepts POST request: "/add"
    @PostMapping("/addGrade")
    public String submitForm(Grade grade) {
        int studentIdx = getStudentGrade(grade.getName());

        if(studentIdx == -1) {
            studentGrades.add(grade);
        } else {
//            Grade existingStudent = studentGrades.get(getStudentGrade(grade.getName()));
//            existingStudent.setName(grade.getName());
//            existingStudent.setSubject(grade.getSubject());
//            existingStudent.setScore(grade.getScore());
            studentGrades.set(studentIdx, grade);

        }
        System.out.println(grade);

        return "redirect:/grades";
    }
    // handler to map a path for GET requests at a specific endpoint
    // responds to get requests @ "/grades"
    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", studentGrades);
        return "grades";
    }

    @GetMapping("/editStudent")
    public String editStudent(Model model, @RequestParam(required = false) String name) {
        int foundIndex = getStudentGrade(name);

//        System.out.println(getStudentGrade(name));
        if (foundIndex == -1) {
            model.addAttribute("grade", new Grade());
        } else {
            model.addAttribute("grade", studentGrades.get(foundIndex));
        }
//        model.addAttribute("grade", foundGrade!= null ? foundGrade : new Grade());
            return "form";
    }

    public int getStudentGrade(String name) {
        for(int i = 0; i < studentGrades.size(); i++) {
            if(studentGrades.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

}
