package com.example.spotmusic.controller;

import com.example.spotmusic.dto.SongDto;
import com.example.spotmusic.model.Album;
import com.example.spotmusic.model.Artist;
import com.example.spotmusic.model.Song;
import com.example.spotmusic.service.AlbumService;
import com.example.spotmusic.service.ArtistService;
import com.example.spotmusic.service.SongService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/song")
@Slf4j
public class SongController {

    @Autowired
    SongService songService;

    @Autowired
    AlbumService albumService;
    
    @Autowired
    ModelMapper modelMapper;


    @PostMapping
    public ResponseEntity<SongDto> addSong(@RequestBody SongDto songDto){
        log.info(songDto.toString());
        Album album = albumService.getAnAlbum(songDto.getAlbumId());
        Song song = modelMapper.map(songDto,Song.class);
        song.setAlbum(album);

        return new ResponseEntity<>(modelMapper.map(songService.addSong(song), SongDto.class), HttpStatus.OK);
    }


}
