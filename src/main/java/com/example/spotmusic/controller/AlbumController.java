package com.example.spotmusic.controller;

import com.example.spotmusic.dto.AlbumDto;
import com.example.spotmusic.model.Album;
import com.example.spotmusic.model.Artist;
import com.example.spotmusic.service.AlbumService;
import com.example.spotmusic.service.ArtistService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/album")
@Slf4j
public class AlbumController {

    private static final String TAG = "AlbumController";

    @Autowired
    AlbumService albumService;

    @Autowired
    ArtistService artistService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<AlbumDto>  addAlbum(@RequestBody AlbumDto albumDto){
        log.error("id {}",albumDto);
        Artist artist = artistService.getArtist(albumDto.getArtistId());
        Album album = modelMapper.map(albumDto, Album.class);
        album.setArtist(artist);

        return new ResponseEntity<>(
                modelMapper.map(albumService.addAlbum(album), AlbumDto.class),
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "{albumId}")
    public ResponseEntity<AlbumDto> getAnAlbumDetail(@PathVariable(name = "albumId") Long id){
        return new ResponseEntity<>(
                modelMapper.map(albumService.getAnAlbum(id), AlbumDto.class),
                HttpStatus.OK
        ) ;
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Boolean> deleteAlbum(@PathVariable(name = "id") Long id){
        if (albumService.deleteAlbum(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<AlbumDto>> getAllAlbum(){
        List<AlbumDto> list = albumService.getAllAlbum()
                .stream()
                .map(album -> modelMapper.map(album, AlbumDto.class))
                .collect(Collectors.toList());

        if(list.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
