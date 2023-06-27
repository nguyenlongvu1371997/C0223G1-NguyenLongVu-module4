package com.example.validate_song.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongCreationDto implements Validator {
    private Integer id;
    @NotBlank(message = "không được để trống")
    @Size(max = 800, message = "không được quá 800 kí tự")
    @Pattern(regexp = "^\\w+(\\s{1}\\w+)*$")
    private String name;
    @NotBlank(message = "không được để trống")
    @Size(max = 300, message = "không được quá 300 kí tự")
    @Pattern(regexp = "^\\w+(\\s{1}\\w+)*$")
    private String artist;
    @NotBlank(message = "không được để trống")
    @Size(max = 1000, message = "không được quá 1000 kí tự")
    @Pattern(regexp = "^\\w+(\\s{1}\\w+)*((,\\s){1}\\w+(\\s{1}\\w+)*)*$")
    private String kindOfMusic;
    private boolean deleteIsTrue;

    public SongCreationDto(String name, String artist, String kindOfMusic, boolean deleteIsTrue) {
        this.name = name;
        this.artist = artist;
        this.kindOfMusic = kindOfMusic;
        this.deleteIsTrue = deleteIsTrue;
    }

    public SongCreationDto(Integer id, String name, String artist, String kindOfMusic, boolean deleteIsTrue) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.kindOfMusic = kindOfMusic;
        this.deleteIsTrue = deleteIsTrue;
    }

    public SongCreationDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public boolean isDeleteIsTrue() {
        return deleteIsTrue;
    }

    public void setDeleteIsTrue(boolean deleteIsTrue) {
        this.deleteIsTrue = deleteIsTrue;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
