package com.example.spotmusic.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long albumId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Date releaseDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    private Artist artist;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "album")
    private List<Song> albumSongList;

}
