package com.klu.workbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.workbook.model.Product;
import com.klu.workbook.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping("/add")
    public Product addProduct(@Valid @RequestBody Product p)
    {
        return service.addProduct(p);
    }
}