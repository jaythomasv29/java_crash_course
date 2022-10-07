package com.ltp.gradesubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class InventoryController {
  private List<Item> inventory = new ArrayList<>();

  @GetMapping("/inventory")
  public String getProducts(Model model) {
    model.addAttribute("items", inventory);
    return "inventory";
  }

  @GetMapping("/addInventory")
  public String getInventoryForm(Model model) {
    // add model attribute for form to be bound to object
    model.addAttribute("item", new Item());
    // add model attribute for form to loop over categories in HTML page
    model.addAttribute("categories", Constants.CATEGORIES);
    return "inventoryForm";
  }

  @GetMapping("/editInventory")
  public String editInventory(Model model, @RequestParam(required= false) String id) {
    model.addAttribute("categories", Constants.CATEGORIES);
    System.out.println("id: " + id);
    int foundIdx = getItemIdxById(id);
    if(foundIdx == -1) {
      model.addAttribute("item", new Item());
    } else {
      model.addAttribute("item", inventory.get(foundIdx));
    }
    return "inventoryForm";
  }

  @PostMapping("/submitItem")
  public String submitInventoryForm(Item item, RedirectAttributes redirectAttributes) {
    int foundIdx = getItemIdxById(item.getId());
    if(foundIdx == -1) {
      redirectAttributes.addFlashAttribute("status", Constants.SUCCESS_STATUS);
      inventory.add(item);
    } else {
      // if the inventory already exists in the List
      Item foundItem = inventory.get(foundIdx);
      // check new date if is within valid range
      System.out.println(within5Days(item.getDate(), foundItem.getDate()));
      if(within5Days(item.getDate(), foundItem.getDate())) {
        // add success flash attribute to model
        redirectAttributes.addFlashAttribute("status", Constants.SUCCESS_STATUS);
        inventory.set(foundIdx, item);
      } else {
        // add success flash attribute to model
        redirectAttributes.addFlashAttribute("status", Constants.FAILED_STATUS);
      }
    }
    return "redirect:/inventory";
  }

  public int getItemIdxById(String id) {
    for(int i = 0; i < inventory.size(); i++) {
      if(inventory.get(i).getId().equals(id)) {
        return i;
      }
    }
    return -1;
  }

  public boolean within5Days(Date newDate, Date oldDate) {
    long diff = Math.abs(newDate.getTime() - oldDate.getTime());
    return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
  }

}
