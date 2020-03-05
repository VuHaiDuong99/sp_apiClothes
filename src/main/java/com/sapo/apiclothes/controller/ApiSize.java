package com.sapo.apiclothes.controller;

import com.sapo.apiclothes.entity.Size;
import com.sapo.apiclothes.service.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/api/size")
public class ApiSize {
    @Autowired
    SizeRepository sizeRepository;
    @GetMapping
    public ResponseEntity<List<Size>> getAllSize(){
        List<Size> listSize = sizeRepository.findAll();
        if(listSize== null){
            return new ResponseEntity<List<Size>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Size>>(listSize,HttpStatus.OK);
    }
    @GetMapping(value ="/{id}")
    public ResponseEntity<Size> getSizeId(@PathVariable("id") int id){
        Size size = sizeRepository.getOne(id);
        if(size == null){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(size,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Size> saveSize(@RequestBody Size size){
        Size size1 = sizeRepository.save(size);
        return new ResponseEntity<>(size,HttpStatus.OK);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Size> updateSize(@RequestBody Size sizeForm , @PathVariable("id") int id){
        Size size = sizeRepository.getOne(id);
        if(size == null){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        size.setName(sizeForm.getName());
        Size updateSize = sizeRepository.save(size);
        return new ResponseEntity<>(updateSize,HttpStatus.OK);
    }
    @DeleteMapping(value ="/{id}")
    public void deleteSize(@PathVariable("id") int id){
        Size size = sizeRepository.getOne(id);
        sizeRepository.delete(size);
    }
}
