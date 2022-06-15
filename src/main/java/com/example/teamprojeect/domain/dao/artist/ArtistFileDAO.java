package com.example.teamprojeect.domain.dao.artist;

import com.example.teamprojeect.mapper.artist.ArtistFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ArtistFileDAO {
    private ArtistFileMapper artistFileMapper;


}
