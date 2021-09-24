package com.example.spotmusic.controller;

import com.example.spotmusic.dto.ArtistDto;
import com.example.spotmusic.model.Artist;
import com.example.spotmusic.service.ArtistService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/artist")
public class ArtisController {

    @Autowired
    ArtistService artistService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<?> getAllArtist(){
        List<ArtistDto> list = artistService.getAllArtist();
        if(list.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping( path = "{id}")
    public ResponseEntity<ArtistDto> getArtistById(@PathVariable(name = "id") Long id){
        Artist artist = artistService.getArtist(id);
        return new ResponseEntity<>(modelMapper.map(artist, ArtistDto.class), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addNewArtist(@RequestBody ArtistDto artisDto){
        ArtistDto a = artistService.addNewArtis(artisDto);
        return ResponseEntity.ok(a);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Boolean> deleteArtist(@PathVariable(name = "id") Long id){
        if(artistService.deleteArtist(id)){
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }


}