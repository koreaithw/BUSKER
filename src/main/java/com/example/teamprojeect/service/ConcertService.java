package com.example.teamprojeect.service;

import com.example.teamprojeect.domain.dao.show.ShowDAO;
import com.example.teamprojeect.domain.dao.show.ShowFileDAO;
import com.example.teamprojeect.domain.dao.show.ShowReplyDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConcertService {
    private ShowDAO showDAO;
    private ShowFileDAO showFileDAO;
    private ShowReplyDAO showReplyDAO;
}
