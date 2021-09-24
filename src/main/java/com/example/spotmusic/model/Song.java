package com.example.spotmusic.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Data
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private Album album;

}
