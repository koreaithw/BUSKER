package com.example.teamprojeect.controller.user;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/*")
public class UserController {
    // 필드 생성


    // 회원가입 페이지 이동
    @GetMapping("/userJoin")
    public String goUserJoin(){
        return "/login/login";
    }
}
