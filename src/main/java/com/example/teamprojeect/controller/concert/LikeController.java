package com.example.teamprojeect.controller.concert;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController("concert.LikeController")
@RequestMapping("/like/*")
public class LikeController {
}
