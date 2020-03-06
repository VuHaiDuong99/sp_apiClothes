package com.sapo.apiclothes.controller;
import com.sapo.apiclothes.entity.Product;
import com.sapo.apiclothes.service.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ="/api/product")
public class ApiProduct {
    @Autowired
    ProductRepository productRepository;
   @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id){
       Product product =productRepository.getOne(id);
       return new ResponseEntity<Product>(product,HttpStatus.OK);


   }
   @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
       List<Product> product = productRepository.findAll();

       return new ResponseEntity<List<Product>>(product,HttpStatus.OK);
   }
   @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product productSave){
       Product product = productRepository.save(productSave);
       return new ResponseEntity("Them Thanh Cong",HttpStatus.OK);
   }
   @PutMapping(value = "/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") int id,@RequestBody  Product productForm){
       Product product = productRepository.getOne(id);
       product.setCategory(productForm.getCategory());
       product.setImage(productForm.getImage());
       product.setName(productForm.getName());
       product.setPrice(productForm.getPrice());
       Product product1 = productRepository.save(product);
       return  new ResponseEntity("Them Thanh Cong",HttpStatus.OK);
   }
   @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") int id){
       Optional<Product> product = productRepository.findById(id);
        if(product == null){
            return new ResponseEntity("not found",HttpStatus.OK);
        }
     else{
            productRepository.deleteById(id);
            return new ResponseEntity("Xóa Thanh Cong",HttpStatus.OK);
        }
   }
}
