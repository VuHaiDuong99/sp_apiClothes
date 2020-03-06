package com.sapo.apiclothes.controller;

import com.sapo.apiclothes.entity.Category;
import com.sapo.apiclothes.service.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/api/category")
public class ApiCategory {
    @Autowired
    CategoryRepository categoryRepository;
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> category = categoryRepository.findAll();
        if(category == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(category,HttpStatus.OK);
    }
    @GetMapping(value ="/{id}")
    public ResponseEntity<Category> getCategoryId(@PathVariable("id") int id ){
        Category category = categoryRepository.getOne(id);
        if(category == null){
            return new ResponseEntity("not found",HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(category,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category categorySave){
        Category category = categoryRepository.save(categorySave);
        return new ResponseEntity("Success",HttpStatus.OK);

    }
    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Void> deleteCat(@PathVariable("id") int id){
        Category category = categoryRepository.getOne(id);
        categoryRepository.delete(category);
        return new ResponseEntity("Sucesss",HttpStatus.OK);
    }
    @PutMapping(value ="/{id}")
    public ResponseEntity<Category> updateCategory(@RequestBody Category categoryForm,@PathVariable("id") int id){
        Category category = categoryRepository.getOne(id);
        if(category == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        category.setName(categoryForm.getName());
        Category updateCategory = categoryRepository.save(category);
        return new ResponseEntity("Success",HttpStatus.OK);

    }


}
