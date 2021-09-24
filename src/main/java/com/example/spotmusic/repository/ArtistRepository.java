package com.example.spotmusic.repository;

import com.example.spotmusic.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
