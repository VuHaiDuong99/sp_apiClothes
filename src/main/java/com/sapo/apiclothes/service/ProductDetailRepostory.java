package com.sapo.apiclothes.service;

import com.sapo.apiclothes.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepostory extends JpaRepository<ProductDetail,Integer> {
}
