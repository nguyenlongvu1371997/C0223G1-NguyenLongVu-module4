package com.example.validate_song.service;

import com.example.validate_song.model.Song;
import com.example.validate_song.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;

    @Override
    public Page<Song> displayListSong(Pageable pageable) {
        return songRepository.findAllByDeleteIsTrueIsFalse(pageable);
    }

    @Override
    public void add(Song song) {
        songRepository.save(song);
    }
}
