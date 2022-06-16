package com.example.teamprojeect.controller.artist;


import com.example.teamprojeect.service.ArtistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/like/artist/*")
public class ArtistLikeController {
    // 필드
    private ArtistService artistService;

    // 좋아요 등록


    // 좋아요 취소


    // 받은 좋아요 개수
}
