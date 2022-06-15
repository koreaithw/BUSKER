package com.example.teamprojeect.service;

import com.example.teamprojeect.domain.dao.artist.ArtistDAO;
import com.example.teamprojeect.domain.dao.artist.ArtistFileDAO;
import com.example.teamprojeect.domain.dao.artist.ArtistReplyDAO;
import com.example.teamprojeect.domain.dao.artist.PaymentDAO;
import com.example.teamprojeect.domain.dao.user.LikeDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistService {
    //필드
    private ArtistDAO artistDAO;
    private ArtistFileDAO artistFileDAO;
    private ArtistReplyDAO artistReplyDAO;
    private LikeDAO likeDAO;
    private PaymentDAO paymentDAO;
}
