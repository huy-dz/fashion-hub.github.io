package com.example.shopweb.service.implement;

import com.example.shopweb.entity.CategoryEntity;
import com.example.shopweb.repository.CategoryRepo;
import com.example.shopweb.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;


    @Override
    public List<CategoryEntity> findAll() {
        return categoryRepo.findAll();
    }

}
