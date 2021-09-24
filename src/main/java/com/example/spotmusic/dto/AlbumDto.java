package com.example.spotmusic.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AlbumDto {

    private Long albumId;
    private String albumTitle;
    private Date albumReleaseDate;
    private Long artistId;

    @Override
    public String toString() {
        return "AlbumDto{" +
                "albumId=" + albumId +
                ", albumTitle='" + albumTitle + '\'' +
                ", albumReleaseDate=" + albumReleaseDate +
                ", artistId=" + artistId +
                '}';
    }
}
