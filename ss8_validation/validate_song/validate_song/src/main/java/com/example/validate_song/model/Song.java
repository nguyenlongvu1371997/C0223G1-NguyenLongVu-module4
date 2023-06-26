package com.example.validate_song.model;

import javax.persistence.*;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String artist;
    private String kindOfMusic;
    private boolean deleteIsTrue;

    public Song() {
    }

    public Song(int id, String name, String artist, String kindOfMusic, boolean deleteIsTrue) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.kindOfMusic = kindOfMusic;
        this.deleteIsTrue = deleteIsTrue;
    }

    public Song(String name, String artist, String kindOfMusic, boolean deleteIsTrue) {
        this.name = name;
        this.artist = artist;
        this.kindOfMusic = kindOfMusic;
        this.deleteIsTrue = deleteIsTrue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
