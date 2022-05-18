package com.example.shopweb.repository;

import com.example.shopweb.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<CategoryEntity, Long> {

}