package com.example.spotmusic.service;

import com.example.spotmusic.dto.ArtistDto;
import com.example.spotmusic.exception.ResourceNotFoundException;
import com.example.spotmusic.model.Artist;
import com.example.spotmusic.repository.ArtistRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArtistService {
    private static final String TAG = "ArtistService";

    private final static String NOT_FOUND_MSG = "%s with id %d not found";

    @Autowired
    ArtistRepository artistRepository;

    @Autowired
    ModelMapper modelMapper;

    public Artist getArtist(Long id){
        log.error("ID {}", id);
        return artistRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(String.format(NOT_FOUND_MSG, TAG, id))
        );
    }

    public List<ArtistDto> getAllArtist(){
        return artistRepository.findAll()
                .stream()
                .map(artist -> modelMapper.map(artist, ArtistDto.class))
                .collect(Collectors.toList());
    }

    public ArtistDto addNewArtis(ArtistDto artisDto){
        Artist artist = artistRepository.save(modelMapper.map(artisDto, Artist.class));
        return modelMapper.map(artist, ArtistDto.class);
    }

    public boolean deleteArtist(Long id) {
        Artist artist = artistRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(String.format(NOT_FOUND_MSG,TAG, id))
        );
        if(artist.getAlbum().size() > 0){
            return false;
        }
        artistRepository.deleteById(id);
        return true;
    }
}
