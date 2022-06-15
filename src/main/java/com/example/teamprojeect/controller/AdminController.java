package com.example.teamprojeect.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/*")
public class AdminController {
    // 필드 생성


    // 관리자 페이지 이동
    @GetMapping("/adminMain")
    public void goAdmin() {;}

}
