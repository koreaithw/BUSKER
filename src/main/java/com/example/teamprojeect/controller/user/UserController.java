package com.example.teamprojeect.controller.user;


import com.example.teamprojeect.domain.vo.user.UserVO;
import com.example.teamprojeect.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;

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

    //로그인
    // 로그인 페이지 이동
    @GetMapping("/login")
    public String goLogin() {
        return "/login/login";
    }

    // 로그인
    // 로그인
    @PostMapping("/loginSuccess")
    public String goMain(UserVO userVO, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userId = userVO.getUserId();
        String userPw = userVO.getUserPw();
        Long userNumber = userService.login(userId, userPw);
        String val = "userNumber";
        session.setAttribute(val, userNumber);

        Long num =  Long.valueOf(String.valueOf((session.getAttribute(val))));
        if(session == null) {
            log.info("===========================================");
            log.info("없어");
        } else {
            log.info("===========================================");
            log.info("있어");
            log.info(num.toString());
        }
        return "/main/main";
    }

    //회원가입
    @PostMapping("/join")
    public String joinPOST(UserVO user) throws Exception{

        log.info("join 진입");

        // 회원가입 서비스 실행
        userService.join(user);

        log.info("join Service 성공");

        return "/main/main";

    }



}
