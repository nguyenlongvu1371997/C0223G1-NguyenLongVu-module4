package com.example.validate_song.service;

import com.example.validate_song.model.Song;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISongService {
    Page<Song> displayListSong(Pageable pageable);
    void add(Song song);
}
