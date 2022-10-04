package com.ltp.gradesubmission;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// controller annotation
// entry point for web requests through GET / POST
@Controller
public class GradeController {

    // handler to map a path for GET requests at a specific endpoint
    // responds to get requests @ "/hello"
    @GetMapping("/hello")
    public String sayHello() {
        return "Im saying hello";

    }



}
