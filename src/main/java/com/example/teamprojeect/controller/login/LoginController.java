package com.example.teamprojeect.controller.login;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/login/*")
public class LoginController {
    // 필드 생성


    // 로그인 페이지 이동
    @GetMapping("/login")
    public String goLogin() {
        return "/login/login";
    }

    // 아이디 찾기 페이지 이동
    @GetMapping("/idFind")
    public String goIdFind() {
        return "/login/idFind";
    }

    // 비밀번호 찾기 페이지 이동
    @GetMapping("/pwFind")
    public String goPwFind() {
        return "/login/pwFind";
    }
}
