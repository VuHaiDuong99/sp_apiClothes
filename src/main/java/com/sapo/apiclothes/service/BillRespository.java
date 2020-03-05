package com.sapo.apiclothes.service;

import com.sapo.apiclothes.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRespository extends JpaRepository<Bill,Integer> {

}
