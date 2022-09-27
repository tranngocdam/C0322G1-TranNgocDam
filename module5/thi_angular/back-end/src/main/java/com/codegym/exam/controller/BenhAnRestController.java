package com.codegym.exam.controller;

import com.codegym.exam.model.BenhAn;
import com.codegym.exam.service.BenhAnService;
import com.codegym.exam.service.MaBenhNhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/benhan")
@CrossOrigin
public class BenhAnRestController {
    @Autowired
    private BenhAnService benhAnService;

    @GetMapping("/page")
    public ResponseEntity<Page<BenhAn>> findAllBenhAn(@PageableDefault(value = 5) Pageable pageable) {
        Page<BenhAn> benhAnPage = benhAnService.findAll(pageable);
        if (benhAnPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(benhAnPage, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<BenhAn> saveBenhAn(@RequestBody BenhAn benhAn) {
        benhAnService.save(benhAn);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<BenhAn> findByIdBenhAn(@PathVariable Integer id) {
        BenhAn benhAn = benhAnService.findByBenhAn(id);
        return new ResponseEntity<>(benhAn, HttpStatus.OK);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<BenhAn> editBenhAn(@RequestBody BenhAn benhAn) {
       benhAnService.editBenhAn(benhAn);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BenhAn> deleteBenhAn(@PathVariable Integer id){
        benhAnService.deleteBenhAn(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<Page<BenhAn>> searchPatient(@RequestParam String liDo,
                                                       @PageableDefault(value = 2) Pageable pageable) {
        Page<BenhAn> benhAnPage = benhAnService.findBenhAnByLiDo(liDo, pageable);
        return new ResponseEntity<>(benhAnPage, HttpStatus.OK);
    }
}
