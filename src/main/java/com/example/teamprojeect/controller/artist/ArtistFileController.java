package com.example.teamprojeect.controller.artist;

import com.example.teamprojeect.service.ArtistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/file/artist/*")
@Controller
public class ArtistFileController {
    // 필드 생성
    private ArtistService artistService;


}
