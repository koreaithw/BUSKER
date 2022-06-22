package com.example.teamprojeect.service;
import com.example.teamprojeect.domain.vo.user.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserServiceTests {
    @Autowired
    private UserService userService;

//    마이페이지 : 유저 정보 수정 테스트 - 성공
//    @Test
//    public void modifyTest(){
//        UserVO userVO = new UserVO();
//
//        userVO.setUserNumber(3L);
//        userVO.setUserName("덤보");
//        userVO.setUserPhoneNumber("01099999999");
//        userVO.setUserEmail("dumbo123@naver.com");
//        userVO.setUserArtistStatus(3L);
//
//        userService.modify(userVO);
//
//        log.info("유저 번호 : " + userVO.getUserNumber());
//    }

//    마이페이지 : 유저 비밀번호 수정 테스트 - 성공
//    @Test
//    public void modifyPwTest(){
//        Long userNumber=3L;
//        String password="7895";
//
//        userService.modifyPw(userNumber, password);
//    }

//    마이페이지 : 유저 탈퇴 - 성공
//    @Test
//    public void removeTest(){
//        Long userNumber = 3L;
//        log.info("IF DELETE : " + userService.remove(userNumber));
//    }

//    마이페이지 : 유저 정보 조회
//    @Test
//    public void readTest(){
//        Long userNumber = 3L;
//        log.info(userService.read(userNumber).toString());
//    }
    //로그인
//    @Test
//    public void loginTest(){
//
//        String userId = "i";
//        String userPw = "1234";
//
//        log.info("로그인 성공" + userService.login(userId,userPw));
//
//    }
}
