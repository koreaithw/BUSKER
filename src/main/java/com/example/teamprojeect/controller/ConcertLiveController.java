package com.example.teamprojeect.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/concertLive/*")
@Slf4j
@RequiredArgsConstructor
public class ConcertLiveController {
    // 필드 생성


    // 진행중인 콘서트 페이지
    @GetMapping("/concertLive")
    public String goConcertLive() {
        return "/concertLive/concertLive";
    }
}
