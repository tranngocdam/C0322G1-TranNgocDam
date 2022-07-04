package com.example.demo.controller;

import com.example.demo.model.Smartphone;
import com.example.demo.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/smartphones")
@CrossOrigin
public class HomeController {
    @Autowired
    private ISmartphoneService iSmartphoneService;
    @PostMapping("/create")
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(iSmartphoneService.save(smartphone), HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("smartphones", iSmartphoneService.findAll());
        return modelAndView;
    }
    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> allPhones() {
        return new ResponseEntity<>(iSmartphoneService.findAll(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = iSmartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iSmartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Smartphone> editSmartPhone(@PathVariable Long id) {
        Optional<Smartphone> smartphone = iSmartphoneService.findById(id);
        if (!smartphone.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(smartphone.get(), HttpStatus.OK);
    }
    @GetMapping("/edit/{id}")
    public ResponseEntity<Optional<Smartphone>> getPhone(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = iSmartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(smartphoneOptional, HttpStatus.OK);
    }

    @PostMapping("/edit")
    public ResponseEntity<Iterable<Smartphone>> updateSmartphone(@RequestBody Smartphone smartphone) {
        iSmartphoneService.save(smartphone);
        return new ResponseEntity<>(iSmartphoneService.findAll(), HttpStatus.NO_CONTENT);
    }
}
