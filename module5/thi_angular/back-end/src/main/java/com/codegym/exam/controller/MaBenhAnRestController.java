package com.codegym.exam.controller;

import com.codegym.exam.model.MaBenhAn;
import com.codegym.exam.service.MaBenhAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/mabenhan")
@CrossOrigin
public class MaBenhAnRestController {
    @Autowired
    private MaBenhAnService maBenhAnService;
    @GetMapping("")
    public ResponseEntity<Iterable<MaBenhAn>> findAllMaBenhAn(){
        List<MaBenhAn> maBenhAnList = maBenhAnService.findAll();
        if(maBenhAnList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(maBenhAnList, HttpStatus.OK);
    }
}
