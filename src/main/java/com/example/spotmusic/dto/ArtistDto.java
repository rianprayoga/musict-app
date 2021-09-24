package com.example.spotmusic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtistDto {
    private Integer artistId;
    private String artistName;
    private List<AlbumDto> artistListAlbum;
}
