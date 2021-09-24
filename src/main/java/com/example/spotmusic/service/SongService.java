package com.example.spotmusic.service;

import com.example.spotmusic.model.Song;
import com.example.spotmusic.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    public Song addSong(Song song){
        return songRepository.save(song);
    }

}
