package com.example.azuredemo.repository;

import com.example.azuredemo.model.ProductCategory;
import org.springframework.data.repository.CrudRepository;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Integer> {
}
