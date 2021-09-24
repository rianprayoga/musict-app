package com.example.spotmusic.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SongDto {

    private Long id;
    private String songTitle;
    private Long albumId;

    @Override
    public String toString() {
        return "SongDto{" +
                "id=" + id +
                ", songTitle='" + songTitle + '\'' +
                ", albumId=" + albumId +
                '}';
    }
}
