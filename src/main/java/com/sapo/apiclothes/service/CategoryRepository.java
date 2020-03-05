package com.sapo.apiclothes.service;

import com.sapo.apiclothes.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository <Category,Integer> {
}
