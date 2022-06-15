package com.example.teamprojeect.service;

import com.example.teamprojeect.domain.dao.*;
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
