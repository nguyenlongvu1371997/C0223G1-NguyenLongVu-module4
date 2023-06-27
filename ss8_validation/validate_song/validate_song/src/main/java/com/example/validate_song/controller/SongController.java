package com.example.validate_song.controller;

import com.example.validate_song.dto.SongCreationDto;
import com.example.validate_song.model.Song;
import com.example.validate_song.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;


    @GetMapping("")
    public String displayListSong(@PageableDefault(size = 5) Pageable pageable, Model model) {
        model.addAttribute("list", songService.displayListSong(pageable));
        return "/displayListSong";
    }

    @GetMapping("/create")
    public String createSong(Model model) {
        model.addAttribute("songCreationDto", new SongCreationDto());
        return "/create";
    }

    @PostMapping("/create")
    public String createSong(@Valid @ModelAttribute SongCreationDto songCreationDto,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new SongCreationDto().validate(songCreationDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songCreationDto, song);
        songService.add(song);
        redirectAttributes.addFlashAttribute("msg", "thêm mới thành công");
        return "redirect:/song/create";
    }

    @GetMapping("/edit")
    public String editSong(@RequestParam int id, Model model, RedirectAttributes redirectAttributes) {
        if (songService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("msg", "không tìm thấy bài hát");
            return "redirect:/song";
        }
        SongCreationDto songCreationDto = new SongCreationDto();
        BeanUtils.copyProperties(songService.findById(id), songCreationDto);
        model.addAttribute("songCreationDto", songCreationDto);
        return "/edit";
    }

    @PostMapping("/edit")
    public String editSong(@Valid @ModelAttribute SongCreationDto songCreationDto,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new SongCreationDto().validate(songCreationDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/edit";
        }

        Song song = new Song();
        BeanUtils.copyProperties(songCreationDto, song);
        if (songService.findById(song.getId()) == null) {
            redirectAttributes.addFlashAttribute("msg", "không tìm thấy bài hát");
            return "redirect:/song";
        }
        songService.add(song);
        redirectAttributes.addFlashAttribute("msg", "sửa thành công");
        return "redirect:/song";
    }

    @GetMapping("/delete")
    public String deleteSong(@RequestParam int id, RedirectAttributes redirectAttributes) {
        if (!songService.findById(id).isPresent()) {
            redirectAttributes.addFlashAttribute("smg", "không tìm thấy để xóa");
            return "redirect:/song";
        }
        songService.deleteSong(id);
        redirectAttributes.addFlashAttribute("smg", "không tìm thấy để xóa");
        return "redirect:/song";
    }
}
