package com.sprint2.controller;

import com.sprint2.model.Discount;
import com.sprint2.service.IDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/api/discount")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DiscountRestController {
    @Autowired
    private IDiscountService iDiscountService;

    @GetMapping("/list")
    public ResponseEntity<List<Discount>> findAllDiscount(){
        List<Discount> discountList = iDiscountService.findAllDiscount();
        if (discountList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(discountList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Discount> findById(@PathVariable Integer id){
        Discount discount = this.iDiscountService.findById(id);
        if(discount==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(discount, HttpStatus.OK);
    }
}
