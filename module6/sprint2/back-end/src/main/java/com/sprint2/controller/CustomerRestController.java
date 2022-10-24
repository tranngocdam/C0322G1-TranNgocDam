package com.sprint2.controller;

import com.sprint2.model.Customer;
import com.sprint2.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/public")
public class CustomerRestController {
    @Autowired
    private ICustomerService iCustomerService;

    @PutMapping("/customer/update")
    public ResponseEntity<?> editCustomer(@RequestBody @Valid Customer customer) {
        iCustomerService.edit(customer.getId(), customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/customer/{userId}")
    public ResponseEntity<Customer> getUser(@PathVariable Integer userId) {
        Customer customer = iCustomerService.findByUserId(userId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
