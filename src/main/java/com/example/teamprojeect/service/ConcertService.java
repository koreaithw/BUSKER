package com.example.teamprojeect.service;

import com.example.teamprojeect.domain.dao.show.ShowDAO;
import com.example.teamprojeect.domain.dao.show.ShowFileDAO;
import com.example.teamprojeect.domain.dao.show.ShowReplyDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConcertService {
    private final ShowDAO showDAO;
    private final ShowFileDAO showFileDAO;
    private final ShowReplyDAO showReplyDAO;
}
