package com.example.spotmusic.service;

import com.example.spotmusic.exception.ResourceNotFoundException;
import com.example.spotmusic.model.Album;
import com.example.spotmusic.repository.AlbumRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    private static final String TAG = "AlbumService";
    private static final String NOT_FOUND_MSG = TAG + " cant found id %d";

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Album> getAllAlbum(){
        return albumRepository.findAll();
    }

    public Album addAlbum(Album album){
        return albumRepository.save(album);
    }

    public Album getAnAlbum(Long id){
        return albumRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(String.format(NOT_FOUND_MSG, id))
        );
    }

    public Boolean deleteAlbum(Long id){
        Album album = albumRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(String.format(NOT_FOUND_MSG, id))
        );
        if (album.getAlbumSongList().size() != 0){
            return false;
        }
        albumRepository.deleteById(id);
        return true;
    }

}