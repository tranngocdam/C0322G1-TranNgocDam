package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.service.ISongService;
import com.codegym.service.impl.ISongServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class SongController {

private final ISongService songService=new ISongServiceImpl();

    @GetMapping("/song")
    public String findAll(Model model) {
        List<Song> songList = songService.findAll();
        model.addAttribute("songList", songList);
        return "/list";
    }

    @GetMapping("/song/create")
    public String showCreate(Model model) {
        model.addAttribute("song", new Song());
        return "/create";
    }
    @PostMapping("/song/create")
    public String addOrUpdate(@ModelAttribute Song song) {
        songService.save(song);
        return "redirect:/song";
    }

    @GetMapping("song/edit/{id}")
    public String showEdit(@PathVariable Integer id, Model model){
        Song song = songService.findById(id);
        model.addAttribute("song",song);
        return "/edit";
    }

    @PostMapping("song/edit")
    public String edit(@ModelAttribute Song song){
        songService.edit(song);
        return "redirect:/song";
    }
    @GetMapping("song/delete/{id}")
    public String delete(@PathVariable Integer id){
        songService.delete(id);
        return "redirect:/song";
    }
}
