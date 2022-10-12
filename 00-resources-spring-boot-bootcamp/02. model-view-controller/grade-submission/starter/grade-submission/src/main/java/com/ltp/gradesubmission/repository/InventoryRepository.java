package com.ltp.gradesubmission.repository;

import com.ltp.gradesubmission.Item;

import java.util.ArrayList;
import java.util.List;

public class InventoryRepository {
  private List<Item> inventory = new ArrayList<>();

  public List<Item> getAllInventory() {
    return inventory;
  }

  public Item getInventory(int index) {
    return inventory.get(index);
  }

  public void addItemToInventory(Item item) {
    inventory.add(item);
  }

  public void updateItemInInventory(int index, Item item) {
    inventory.set(index, item);
  }




}
