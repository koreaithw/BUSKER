package com.example.teamprojeect.controller.user;


import com.example.teamprojeect.domain.vo.user.UserVO;
import com.example.teamprojeect.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Service;
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

    // 아이디 찾기 페이지 이동
    @PostMapping("/idFindResult")
    public String resultIdFind(String userPhoneNumber, Model model) {
        if( !((userService.findCount(userPhoneNumber)) == 0L)) {
            UserVO userVO = userService.find(userPhoneNumber);
            String userName = userVO.getUserId();
            model.addAttribute("userVO", userVO);
            return "/login/idFindResult";
        } else {
            model.addAttribute("alert", "일치하는 휴대폰 번호가 없습니다. 다시 입력해주세요.");
            return "/login/idFind";
        }
    }

//    @PostMapping("/searchIdFind")
//    public String searchIdFind(String userPhoneNumber) {
//        userService.id
//        return "/login/idFindResult";
//    }

    // 비밀번호 찾기 페이지 이동
    @GetMapping("/pwFind")
    public String goPwFind() {
        return "/login/pwFind";
    }

    // 비밀번호 찾기 페이지 이동
    @PostMapping("/pwFindResult")
    public String resultPwFind(UserVO userVO, Model model) {
        log.info(userVO.getUserId());
        log.info(userVO.getUserPhoneNumber());
        if( !((userService.findPwCount(userVO)) == 0L)) {
            UserVO userVOResult = userService.find(userVO.getUserPhoneNumber());
            String userName = userVOResult.getUserId();
            model.addAttribute("userVO", userVOResult);
            return "/login/pwFindResult";
        } else {
            model.addAttribute("alert", "일치하는 아이디 혹은 휴대폰 번호가 없습니다. 다시 입력해주세요.");
            log.info("야야야야ㅑ");
            return "/login/pwFind";
        }
    }


    //로그인
    // 로그인 페이지 이동
    @GetMapping("/login")
    public String goLogin() { return "/login/login"; }



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
        log.info(user.toString());
        userService.join(user);

        log.info("join Service 성공");

        return "/main";

    }

    // 아이디 중복확인
    @PostMapping(value = "/{userId}", produces = "text/plain; charset=utf-8")
    @ResponseBody
    public String searchId(@PathVariable("userId") String userId, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        log.info(userService.searchId(userId));
        return userService.searchId(userId);
    }
}
