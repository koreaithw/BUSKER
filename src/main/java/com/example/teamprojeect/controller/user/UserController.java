package com.example.teamprojeect.controller.user;


import com.example.teamprojeect.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user/*")
public class UserController {
    // 필드 생성
    private final UserService userService;

    // 회원가입 페이지 이동
    @GetMapping("/userJoin")
    public String goUserJoin(){
        return "/user/userJoin";
    }
}
