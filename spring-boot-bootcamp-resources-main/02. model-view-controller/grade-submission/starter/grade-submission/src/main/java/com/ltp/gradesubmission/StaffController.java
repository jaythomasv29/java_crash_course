package com.ltp.gradesubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class StaffController {

  @GetMapping("/staff")
  public String getStaff(Model model) {
    List<Staff> staffList = Arrays.asList(
      new Staff("Jim Halpert", 32, "Salesman", 35.2, 40.2),
      new Staff("Anbdy Bernard", 38, "Salesman", 33.3, 35.5),
      new Staff("Pam Beasly", 32, "Receptionist", 42.7, 33.9),
      new Staff("Michael Scott", 32, "Regional Manager", 27.3,23.25),
      new Staff("Dwight Schrute", 37, "Assistant to the Regional Manager", 55.25, 35)
    );
    model.addAttribute("staffList",staffList);
    return "staff";
  }
}
