package com.example.validate_song.controller;

import com.example.validate_song.SongDto.SongCreationDto;
import com.example.validate_song.model.Song;
import com.example.validate_song.repository.ISongRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongRepository songRepository;

    @GetMapping("")
    public String displayListSong(@PageableDefault(size = 5) Pageable pageable, Model model) {
        model.addAttribute("list", songRepository.findAllByDeleteIsTrueIsFalse(pageable));
        return "/displayListSong";
    }

    @GetMapping("/create")
    public String createSong(Model model){
        model.addAttribute("songCreationDto",new SongCreationDto());
        return "/create";
    }

    @PostMapping("/create")
    public String createSong(@Valid @ModelAttribute SongCreationDto songCreationDto,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new SongCreationDto().validate(songCreationDto, bindingResult);
        if(bindingResult.hasErrors()){
            return "/create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songCreationDto,song);
        songRepository.save(song);
        redirectAttributes.addFlashAttribute("msg","thêm mới thành công");
        return "redirect:/create";
    }
}
