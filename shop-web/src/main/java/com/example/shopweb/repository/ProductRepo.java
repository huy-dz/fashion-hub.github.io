package com.example.shopweb.repository;

import com.example.shopweb.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface ProductRepo extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findAll();
    Optional<ProductEntity> findById(Long id);
    Optional<ProductEntity> findByCode(String code);
    Page<ProductEntity> findAllByCategory_Code(String code, Pageable pageable);

    @Query("SELECT p FROM ProductEntity p WHERE p.name LIKE %?1%")
    Page<ProductEntity> search(String name, Pageable pageable);
}
