package com.example.teamprojeect.controller.artist;

import com.example.teamprojeect.service.ArtistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/payment/artist/*")
public class ArtistPaymentController {
    private ArtistService artistService;

    // 아티스트 받은 후원 목록



}
