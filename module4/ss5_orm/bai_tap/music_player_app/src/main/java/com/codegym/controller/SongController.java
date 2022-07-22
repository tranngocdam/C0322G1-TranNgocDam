package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping
public class SongController {
    @Autowired
    private ISongService iSongService;

    @GetMapping(value = "/song")
    public String findAll(Model model) {
        List<Song> songList = iSongService.findAll();
        model.addAttribute("songList", songList);
        return "/list";
    }

    @GetMapping("/song/create")
    public String showCreate(Model model) {
        model.addAttribute("song", new Song());
        return "/create";
    }

    @PostMapping("/song/create")
    public String save(@ModelAttribute Song song) {
        iSongService.save(song);
        return "redirect:/song";
    }

    @GetMapping("song/{id}/edit")
    public String showEdit(@PathVariable Integer id, Model model) {
        Song song = iSongService.findById(id);
        model.addAttribute("song", song);
        return "/edit";
    }

    @PostMapping("song/edit")
    public String edit(@ModelAttribute Song song) {
        iSongService.edit(song);
        return "redirect:/song";
    }

    @GetMapping("song/{id}/delete")
    public String delete(@PathVariable Integer id) {
        iSongService.delete(id);
        return "redirect:/song";
    }
}
