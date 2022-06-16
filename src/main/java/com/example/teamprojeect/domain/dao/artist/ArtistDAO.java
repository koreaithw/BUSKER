package com.example.teamprojeect.domain.dao.artist;

import com.example.teamprojeect.domain.vo.artist.ArtistFileVO;
import com.example.teamprojeect.mapper.artist.ArtistMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ArtistDAO {
    private final ArtistMapper artistMapper;


}
