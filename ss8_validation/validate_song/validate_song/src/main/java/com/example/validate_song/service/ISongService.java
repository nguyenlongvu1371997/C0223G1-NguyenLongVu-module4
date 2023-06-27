package com.example.validate_song.service;

import com.example.validate_song.model.Song;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ISongService {
    Page<Song> displayListSong(Pageable pageable);
    void add(Song song);
    Optional<Song> findById(int id);
    void deleteSong(int id);
}
