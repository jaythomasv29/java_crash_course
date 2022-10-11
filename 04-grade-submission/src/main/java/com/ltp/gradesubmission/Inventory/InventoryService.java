package com.ltp.gradesubmission.Inventory;

import com.ltp.gradesubmission.Constants.Constants;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class InventoryService {
  InventoryRepository inventoryRepository = new InventoryRepository(); // new Repository that is a Model

  public List<Item> getAllInventory() {
    return inventoryRepository.getAllInventory();
  }

  public Item getInventory(int index) {
    return inventoryRepository.getInventory(index);
  }

  public int getItemIdxById(String id) {
    for(int i = 0; i < getAllInventory().size(); i++) {
      if(getAllInventory().get(i).getId().equals(id)) {
        return i;
      }
    }
    return -1;
  }

  public void addItemToInventory(Item item) {
    inventoryRepository.addItemToInventory(item);
  }

  public String handleSubmit(Item item) {
    int foundIdx = getItemIdxById(item.getId());
    String status = Constants.SUCCESS_STATUS;
    if(foundIdx == -1) {
      addItemToInventory(item);
      // if the inventory already exists in the List
    } else {
      Item foundItem = getInventory(foundIdx);
      // check new date if is within valid range
      if(within5Days(item.getDate(), foundItem.getDate())){
        updateInventoryItem(foundIdx, item);
      } else {
        status = Constants.FAILED_STATUS;
      }
    }
    return status;
  }

  public void updateInventoryItem(int index, Item item) {
    inventoryRepository.updateItemInInventory(index, item);
  }

  public boolean within5Days(Date newDate, Date oldDate) {
    long diff = Math.abs(newDate.getTime() - oldDate.getTime());
    return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
  }

}
