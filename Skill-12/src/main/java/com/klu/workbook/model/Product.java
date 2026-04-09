package com.klu.workbook.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message="Product name cannot be empty")
    private String name;

    @Size(min=3,message="Description must be at least 3 characters")
    private String description;

    @Positive(message="Price must be greater than 0")
    private double price;

    @Positive(message="Quantity must be positive")
    private int quantity;

    public Product(){}

    public int getId(){ return id; }
    public void setId(int id){ this.id=id; }

    public String getName(){ return name; }
    public void setName(String name){ this.name=name; }

    public String getDescription(){ return description; }
    public void setDescription(String description){ this.description=description; }

    public double getPrice(){ return price; }
    public void setPrice(double price){ this.price=price; }

    public int getQuantity(){ return quantity; }
    public void setQuantity(int quantity){ this.quantity=quantity; }
}