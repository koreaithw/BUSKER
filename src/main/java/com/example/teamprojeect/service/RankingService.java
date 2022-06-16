package com.example.teamprojeect.service;

import com.example.teamprojeect.domain.dao.artist.ArtistDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RankingService {
    private final ArtistDAO artistDAO;
}
