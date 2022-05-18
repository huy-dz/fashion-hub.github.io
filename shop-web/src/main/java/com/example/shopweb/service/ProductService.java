package com.example.shopweb.service;

import com.example.shopweb.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    ProductEntity findById(Long id);

    ProductEntity findByCode(String code);

    Page<ProductEntity> findAllByCategory_Code(String code, Pageable pageable);

    Page<ProductEntity> search(String name, Pageable pageable);
}
