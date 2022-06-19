package com.controller;

import com.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("music/")
public class SongController {
    @RequestMapping(value = "show", method = RequestMethod.GET)
    public String show(Model model){
        model.addAttribute("song",new Song());
        return "song/create";
    }
    @RequestMapping(value = "/addMusic", method = RequestMethod.POST)
    public String music(@ModelAttribute Song song, Model model){
        model.addAttribute("tenBaiHat", song.getTenBaiHat());
        model.addAttribute("ngheSi", song.getNgheSi());
        model.addAttribute("theLoaiNhac", song.getTheLoaiNhac());
        model.addAttribute("duongDan", song.getDuongDan());
        return "song/info";
    }
}
