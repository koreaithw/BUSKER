package com.example.teamprojeect.domain.dao;

import com.example.teamprojeect.mapper.ArtistFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ArtistFileDAO {
    private ArtistFileMapper artistFileMapper;


}
