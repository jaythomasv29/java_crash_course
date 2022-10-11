package com.ltp.gradesubmission.Inventory;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.UUID;

public class Item {
  private String id;
  @NotBlank(message = "Please choose a category")
  private String category;
  @NotBlank(message = "Name cannot be blank")
  private String name;
  @Min(value = 0, message = "Price cannot be negative")
  private Double price;
  @Min(value = 0, message = "Discount cannot be negative")
  private Double discount;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @NotNull(message = "Date cannot be blank")
  @Past(message = "Date must be in the past")
  private Date date;

  public Item() {
    this.id = UUID.randomUUID().toString();
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Item{" +
      "id='" + id + '\'' +
      ", category='" + category + '\'' +
      ", name='" + name + '\'' +
      ", price=" + price +
      ", discount=" + discount +
      ", date=" + date +
      '}';
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getDiscount() {
    return discount;
  }

  public void setDiscount(Double discount) {
    this.discount = discount;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
}
