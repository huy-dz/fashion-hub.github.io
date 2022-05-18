package com.example.shopweb.repository;

import com.example.shopweb.entity.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepo extends JpaRepository<BillEntity, Long> {

}
