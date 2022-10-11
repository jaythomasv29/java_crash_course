package com.ltp.gradesubmission.Inventory;

import com.ltp.gradesubmission.Inventory.Item;
import com.ltp.gradesubmission.Inventory.InventoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class InventoryController {
  InventoryService inventoryService = new InventoryService();

  @GetMapping("/inventory")
  public String getProducts(Model model) {
    model.addAttribute("items", inventoryService.getAllInventory());
    return "inventory";
  }

  @GetMapping("/addInventory")
  public String getInventoryForm(Model model) {
    // add model attribute for form to be bound to object
    model.addAttribute("item", new Item());
    // add model attribute for form to loop over categories in HTML page
//    model.addAttribute("categories", Constants.CATEGORIES);
    return "inventoryForm";
  }

  @GetMapping("/editInventory")
  public String editInventory(Model model, @RequestParam(required= false) String id) {
//    model.addAttribute("categories", Constants.CATEGORIES);
    System.out.println("id: " + id);
    int foundIdx = inventoryService.getItemIdxById(id);
    if(foundIdx == -1) {
      model.addAttribute("item", new Item());
    } else {
      model.addAttribute("item", inventoryService.getInventory(foundIdx));
    }
    return "inventoryForm";
  }

  @PostMapping("/submitItem")
  public String submitInventoryForm(@Valid Item item, BindingResult result, RedirectAttributes redirectAttributes) {
    if (item.getPrice() == null || item.getDiscount() == null) {
      result.rejectValue("price", "", "Price / Discount cannot be empty");
      return "inventoryForm";
    }

//    cross-field validation to price and discount
    if( item.getPrice() < item.getDiscount()) {
      result.rejectValue("price", "", "Price cannot be less than discount");

    }
    if(result.hasErrors()) return "inventoryForm";
    String status = inventoryService.handleSubmit(item);
    redirectAttributes.addFlashAttribute("status", status);
    return "redirect:/inventory";
  }



}
