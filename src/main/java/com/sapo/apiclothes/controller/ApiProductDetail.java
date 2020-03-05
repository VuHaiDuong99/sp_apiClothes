package com.sapo.apiclothes.controller;

import com.sapo.apiclothes.entity.ProductDetail;
import com.sapo.apiclothes.service.ProductDetailRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController

@RequestMapping(value ="/api/productdetail")
public class ApiProductDetail {
    @Autowired
    ProductDetailRepostory productDetailRepostory;
    @GetMapping
    public ResponseEntity<List<ProductDetail>> getAll(){
        List<ProductDetail> proList=productDetailRepostory.findAll();
        if(proList == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(proList,HttpStatus.OK);
    }
    @GetMapping(value ="/{id}")
    public ResponseEntity<ProductDetail> getAll(@PathVariable("id") int id){
        ProductDetail pro=productDetailRepostory.getOne(id);
        if(pro == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pro,HttpStatus.OK);
    }
    @PostMapping
    public void saveProductDetail(@RequestBody ProductDetail productDetail){
        productDetailRepostory.save(productDetail);
    }
    @PutMapping(value ="/{id}")
    public ResponseEntity<ProductDetail> updateProDetail(@RequestBody ProductDetail proForm,@PathVariable("id") int id){
        ProductDetail productDetail = productDetailRepostory.getOne(id);
        productDetail.setColor(proForm.getColor());
        productDetail.setProduct(proForm.getProduct());
        productDetail.setSize(proForm.getSize());
        productDetail.setAmount(proForm.getAmount());
        ProductDetail pro = productDetailRepostory.save(productDetail);
        return new ResponseEntity<>(pro,HttpStatus.OK);

    }
    @DeleteMapping(value = "/{id}")
    public void deleteProductDetail(@PathVariable("id") int id){
        ProductDetail pro = productDetailRepostory.getOne(id);
        productDetailRepostory.delete(pro);
    }
}

