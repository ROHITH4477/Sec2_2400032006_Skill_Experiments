package com.klu.workbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.workbook.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

}