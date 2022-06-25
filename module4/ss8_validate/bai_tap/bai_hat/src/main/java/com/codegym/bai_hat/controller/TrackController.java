package com.codegym.bai_hat.controller;

import com.codegym.bai_hat.dto.TrackDto;
import com.codegym.bai_hat.model.Track;
import com.codegym.bai_hat.service.ITrackService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TrackController {
    @Autowired
    private ITrackService iTrackService;

    @GetMapping("/track")
    public String showAll(Pageable pageable, Model model){
        Page<Track> trackList = iTrackService.findAll(pageable);
        model.addAttribute("trackList",trackList);
        return "track/list";
    }
    @GetMapping("/track/create")
    public String showCreate(Model model){
        model.addAttribute(new TrackDto());
        return "track/create";
    }

    @PostMapping("/track/create")
    public String create(@Validated @ModelAttribute TrackDto trackDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new TrackDto().validate(trackDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "track/create";
        }
        Track track = new Track();
        BeanUtils.copyProperties(trackDto,track);
        iTrackService.save(track);
        redirectAttributes.addFlashAttribute("saveSC","Save or Update Successfully!");
        return "redirect:/track";
    }
    @GetMapping("/track/{id}/update")
    public String showUpdate(@Validated @PathVariable Integer id, Model model){
        TrackDto trackDto = new TrackDto();
        Track track = iTrackService.findById(id);
        BeanUtils.copyProperties(track,trackDto);
        model.addAttribute("trackDto",trackDto);
        return "track/update";
    }

    @PostMapping("/track/update")
    public String update(@Validated @ModelAttribute TrackDto trackDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new TrackDto().validate(trackDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "track/update";
        }
        Track track = new Track();
        BeanUtils.copyProperties(trackDto,track);
        iTrackService.save(track);
        redirectAttributes.addFlashAttribute("updateSC","Update Successfully!");
        return "redirect:/track";
    }
}
