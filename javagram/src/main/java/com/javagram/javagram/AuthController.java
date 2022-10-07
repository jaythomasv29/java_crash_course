package com.javagram.javagram;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AuthController {

  @GetMapping("/")
  public String getIndex() {
    return "index";
  }

  @GetMapping("/auth/signup")
  public String getSignupForm(Model model) {
    model.addAttribute("user", new User());
    return "signup";
  }

  @GetMapping("/result")
  public String getResult() {
    return "result";
  }

  @PostMapping("/registerUser")
  public String registerUser(@Valid User user, BindingResult result) {
    if(user.getFirstName().equals(user.getLastName())) {
      result.rejectValue("lastName", "", "Please enter valid data");
    }
    if(result.hasErrors()) return "signup";
    return "redirect:/result";
  }
}
