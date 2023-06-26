package com.example.validate_song.repository;

import com.example.validate_song.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISongRepository extends JpaRepository<Song, Integer> {
    Page<Song> findAllByDeleteIsTrueIsFalse(Pageable pageable);
}
