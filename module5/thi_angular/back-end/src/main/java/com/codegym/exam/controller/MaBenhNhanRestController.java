package com.codegym.exam.controller;

import com.codegym.exam.model.MaBenhNhan;
import com.codegym.exam.service.MaBenhNhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/mabenhnhan")
@CrossOrigin
public class MaBenhNhanRestController {
    @Autowired
    private MaBenhNhanService maBenhNhanService;
    @GetMapping("")
    public ResponseEntity<Iterable<MaBenhNhan>>finaAllMabenhNhan(){
        List<MaBenhNhan> maBenhNhanList =maBenhNhanService.findAll();
        if (maBenhNhanList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(maBenhNhanList, HttpStatus.OK);
    }
}
