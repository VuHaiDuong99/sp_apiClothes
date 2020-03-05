package com.sapo.apiclothes.controller;

import com.sapo.apiclothes.dao.ProductDetail;
import com.sapo.apiclothes.entity.Color;
import com.sapo.apiclothes.entity.Product;
import com.sapo.apiclothes.entity.Product_DetailMapper;
import com.sapo.apiclothes.entity.Product_ProductDetail;
import com.sapo.apiclothes.service.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value ="/api/product")
public class ApiProduct {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductDetail productDetail;
   @GetMapping(value = "/{id}")
    public ResponseEntity<List<Product_ProductDetail>> getProductById(@PathVariable("id") int id){
       List list =productDetail.getProductDetailById(id);


       return new ResponseEntity<List<Product_ProductDetail>>(list, HttpStatus.OK);
   }
   @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
       List<Product> product = productRepository.findAll();

       return new ResponseEntity<List<Product>>(product,HttpStatus.OK);
   }
   @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product productSave){
       Product product = productRepository.save(productSave);
       return new ResponseEntity<>(product,HttpStatus.OK);
   }
   @PutMapping(value = "/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") int id,@RequestBody  Product productForm){
       Product product = productRepository.getOne(id);
       product.setCategory(productForm.getCategory());
       product.setImage(productForm.getImage());
       product.setName(productForm.getName());
       product.setPrice(productForm.getPrice());
       Product product1 = productRepository.save(product);
       return  new ResponseEntity<>(product1,HttpStatus.OK);
   }
   @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") int id){
       Product product = productRepository.getOne(id);
        if(product == null){
            return new ResponseEntity<String>("Khong Xoa Duoc",HttpStatus.NO_CONTENT);
        }
       productRepository.delete(product);
        return new ResponseEntity<String>("Ok",HttpStatus.OK);
   }
}
