package org.akaichi.springmvc;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Name;
    private String Address;
    private String Number;
    private String Email;
    private String Url;
    private String Description;
    private String Category;

    public Shop() {}

    public Shop(String Name, String Address, String Number, String Email, String Url, String Description, int Category) {
        this.Name = Name;
        this.Address = Address;
        this.Number = Number;
        this.Email = Email;
        this.Url = Url;
        this.Description = Description;
        this.Category = ShopCategory.getCategory(Category);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public String getNumber() {
        return Number;
    }

    public String getEmail() {
        return Email;
    }

    public String getUrl() {
        return Url;
    }

    public String getDescription() {
        return Description;
    }

    public String getCategory() {
        return Category;
    }

    public int getCategoryInt() {
        return ShopCategory.Categories.valueOf(Category).ordinal();
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setCategory(int category) {
        Category = ShopCategory.getCategory(category);
    }

    public void setCategoryInt(int category) {
        Category = ShopCategory.getCategory(category);
    }

    @Override
    public String toString() {
        return "Shop [Id=" + id + ", Name=" + Name + ", Category=" + Category + "]";
    }
}
