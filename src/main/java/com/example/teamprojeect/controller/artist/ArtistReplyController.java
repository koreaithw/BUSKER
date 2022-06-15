package com.example.teamprojeect.controller.artist;


import com.example.teamprojeect.service.ArtistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/reply/artist/*")
public class ArtistReplyController {
    // 필드 생성
    private ArtistService artistService;
}
