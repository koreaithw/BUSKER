package com.example.teamprojeect.controller.mypage;


import com.example.teamprojeect.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/myPage/*")
public class MypageController {
    // 필드 생성
    private final UserService userService;

    // 마이페이지 이동
    @GetMapping("/myPage")
    public String goMypage() {
        return "/myPage/myPage";
    }

    // 유저 정보 수정


    // 비밀번호 수정


    // 회원 탈퇴
}
