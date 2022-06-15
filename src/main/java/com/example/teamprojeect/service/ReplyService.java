package com.example.teamprojeect.service;

import com.example.teamprojeect.domain.dao.artist.ArtistReplyDAO;
import com.example.teamprojeect.domain.dao.show.ShowReplyDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private ArtistReplyDAO artistReplyDAO;
    private ShowReplyDAO showReplyDAO;
}
