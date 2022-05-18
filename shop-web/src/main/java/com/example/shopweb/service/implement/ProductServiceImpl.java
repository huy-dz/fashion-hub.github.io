package com.example.shopweb.service.implement;

import com.example.shopweb.entity.ProductEntity;
import com.example.shopweb.repository.ProductRepo;
import com.example.shopweb.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    @Override
    public ProductEntity findById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public ProductEntity findByCode(String code) {
        return productRepo.findByCode(code).orElse(null);
    }


    @Override
    public Page<ProductEntity> findAllByCategory_Code(String code, Pageable pageable) {
        return productRepo.findAllByCategory_Code(code, pageable);
    }

    @Override
    public Page<ProductEntity> search(String name, Pageable pageable) {
        return productRepo.search(name, pageable);
    }

}
