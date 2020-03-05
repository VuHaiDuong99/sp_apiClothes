package com.sapo.apiclothes.service;

import com.sapo.apiclothes.dao.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

@Service
@Repository
public class Product_DetailService {
    @Autowired
    ProductDetail productDetail;
    public List getAllById(int id){
     return    productDetail.getProductDetailById(id);
    }
}
