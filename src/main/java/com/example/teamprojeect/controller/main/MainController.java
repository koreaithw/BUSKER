package com.example.teamprojeect.controller.main;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/main/*")
public class MainController {
    // 필드 생성


    // 메인페이지 이동
    @GetMapping("/")
    public String goMain() {
        return "/main/main";
    }
}
