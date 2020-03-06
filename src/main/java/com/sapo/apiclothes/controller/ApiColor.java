package com.sapo.apiclothes.controller;

import com.sapo.apiclothes.entity.Color;
import com.sapo.apiclothes.service.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/api/color")
public class ApiColor {
    @Autowired
    ColorRepository colorRepository;
    @GetMapping
    public ResponseEntity<List<Color>> getAllColor(){
        List<Color> color = colorRepository.findAll();
        if(color == null){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<List<Color>>(color,HttpStatus.OK);
    }
    @GetMapping(value ="/{id}")
    public ResponseEntity<Color> getColorById(@PathVariable("id") int id){
        Color color = colorRepository.getOne(id);
        if(color == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Color>(color,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Color> addColor(@RequestBody Color colorSave){
        Color color = colorRepository.save(colorSave);
        return new ResponseEntity("Success",HttpStatus.OK);
    }
    @PutMapping(value ="/{id}")
    public ResponseEntity<Color> updateColor(@RequestBody Color colorForm,@PathVariable("id") int id){
        Color color = colorRepository.getOne(id);
        color.setName(colorForm.getName());
        Color color1 = colorRepository.save(color);
        return new ResponseEntity("Success",HttpStatus.OK);

    }
    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Void> deleteColor(@PathVariable("id") int id){
        Color color = colorRepository.getOne(id);
        colorRepository.delete(color);
        return new ResponseEntity("Success",HttpStatus.OK);
    }
}
