package com.example.teamprojeect.controller.user;


import com.example.teamprojeect.domain.vo.artist.ArtistVO;
import com.example.teamprojeect.domain.vo.user.UserVO;
import com.example.teamprojeect.service.ArtistService;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user/*")
public class UserController {
    // 필드 생성
    private final UserService userService;
    private final ArtistService artistService;

    // 회원가입 페이지 이동
    @GetMapping("/userJoin")
    public String goUserJoin() {
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
        if (!((userService.findCount(userPhoneNumber)) == 0L)) {
            UserVO userVOResult = userService.find(userPhoneNumber);
            String userName = userVOResult.getUserId();

            try {
                String userRegisterDate = userVOResult.getUserRegisterDate();
                SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date day = dayFormat.parse(userRegisterDate);
                userRegisterDate = dayFormat.format(day);
                userVOResult.setUserRegisterDate(userRegisterDate);

            } catch (ParseException e) {
                System.err.println("dateStr : "  + ", datePattern:");
                e.printStackTrace();
            }

            model.addAttribute("userVO", userVOResult);
            return "/login/idFindResult";
        } else {
            model.addAttribute("alert", "일치하는 휴대폰 번호가 없습니다. 다시 입력해주세요.");
            return "/login/idFind";
        }
    }

    // 휴대폰번호조회
    @PostMapping("/phoneNumberSearch/{userPhoneNumber}")
    @ResponseBody
    public boolean phoneNumberSearch(@PathVariable("userPhoneNumber") String userPhoneNumber) {
        if (!((userService.findCount(userPhoneNumber)) == 0L)) { // 조회되는 개수가 1개이상이면
            return true;
        } else {
            return false;
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
        if (!((userService.findPwCount(userVO)) == 0L)) {
            UserVO userVOResult = userService.find(userVO.getUserPhoneNumber());

            try {
                String userRegisterDate = userVOResult.getUserRegisterDate();
                SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date day = dayFormat.parse(userRegisterDate);
                userRegisterDate = dayFormat.format(day);
                userVOResult.setUserRegisterDate(userRegisterDate);

            } catch (ParseException e) {
                System.err.println("dateStr : "  + ", datePattern:");
                e.printStackTrace();
            }

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
    public String goLogin() {
        return "/login/login";
    }

    // 로그인
    @PostMapping("/loginSuccess")
    public String goMain(UserVO userVO, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();

        String userId = userVO.getUserId();
        String userPw = userVO.getUserPw();

        Long userNumber = userService.login(userId, userPw); // 로그인 시도 후 유저넘버를 가져옴
        log.info("11111111111111111111111111111111" + userNumber);
        if (userNumber != null) { // 아디, 비번이 있으면
            session.setAttribute("userNumber", userNumber); // 세션에 유저 넘버가 담김

            if((userService.read(userNumber)).getUserStatus() == 3 ) {
                session.setAttribute("userStatus", userService.read(userNumber).getUserStatus());
            }

//            session.setAttribute("userId", userId); // 세션에 유저 넘버가 담김
            Long userNumberSession = Long.valueOf(String.valueOf((session.getAttribute("userNumber"))));
            session.setAttribute("sessionCheck", "u");
            log.info("55555555555555555555555555555555555"+artistService.getDetail2(userNumber));
            // 아티스트 넘버가 있으면
            if(artistService.getDetail2(userNumber)!=null) {
                ArtistVO artistVO = artistService.getDetail2(userNumber);
                Long artistNumber = artistVO.getArtistNumber();
                session.setAttribute("artistNumber", artistNumber);
                log.info("99999999999999999999999999999"+artistNumber);
                log.info("혹시 널로 나오닡" + session.getAttribute("artistNumber"));

            } else { // 없으면
                // 아티스트 넘버 세션 null
            }

        } else { // 없으면
            model.addAttribute("message", "일치하는 아이디와 비밀번호가 없습니다. 다시 입력해주세요.");
            return "/login/login";
        }
        return "/main/main";
    }


    // 로그아웃
    @GetMapping("/logout")
    public String goLogout(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null) session.invalidate();
        return "/main/main";
    }


    //회원가입
    @PostMapping("/join")
    public String joinPOST(UserVO user, Model model) throws Exception {

        log.info("join 진입");

        // 회원가입 서비스 실행
        log.info(user.toString());
        userService.join(user);

        log.info("join Service 성공");
        model.addAttribute("message", "회원가입이 완료되었습니다. 로그인 후 이용해주세요.");
        return "/login/login";

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
