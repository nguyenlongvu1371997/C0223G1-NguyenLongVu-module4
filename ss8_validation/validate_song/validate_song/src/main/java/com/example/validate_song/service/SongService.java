package com.example.validate_song.service;

import com.example.validate_song.model.Song;
import com.example.validate_song.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public Optional<Song> findById(int id) {
        return songRepository.findById(id);
    }

    @Override
    public void deleteSong(int id) {
        songRepository.deleteById(id);
    }
}
