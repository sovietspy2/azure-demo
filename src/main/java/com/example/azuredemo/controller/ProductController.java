package com.example.azuredemo.controller;

import com.example.azuredemo.model.ProductCategory;
import com.example.azuredemo.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @GetMapping("/product")
    private List<ProductCategory> getData() {
        List<ProductCategory> list = new ArrayList<>();
        productCategoryRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }


}
