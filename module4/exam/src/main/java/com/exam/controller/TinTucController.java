package com.exam.controller;

import com.exam.dto.TinTucDto;
import com.exam.model.TinTuc;
import com.exam.service.IDanhMucService;
import com.exam.service.ITinTucService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tintuc")
public class TinTucController {
    @Autowired
    private IDanhMucService iDanhMucService;
    @Autowired
    private ITinTucService iTinTucService;


    @GetMapping("")
    public String showHome( Model model) {
//        List<TinTuc> tinTuc=iTinTucService.searchTieuDe(name).;
        model.addAttribute("tintucs", iTinTucService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("tintucs", new TinTuc());
        model.addAttribute("danhmucs", iDanhMucService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String saveCreate( @ModelAttribute TinTuc tinTuc, Model model) {
        iTinTucService.save(tinTuc);
        return "redirect:/tintuc";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        iTinTucService.delete(id);
        return "redirect:/tintuc";
    }
}
