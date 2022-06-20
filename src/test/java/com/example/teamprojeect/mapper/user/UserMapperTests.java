package com.example.teamprojeect.mapper.user;

import com.example.teamprojeect.domain.vo.user.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Slf4j
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;

//    회원가입 : 회원가입 매퍼테스트 - 성공
//    @Test
//    public void joinTest() {
//        IntStream.rangeClosed(1,30).forEach(i -> {
//        UserVO userVO = new UserVO();
//
//        userVO.setUserId("새로 추가한 유저 "  + i);
//        userVO.setUserPw("새로 추가한 유저 비밀번호 " + i);
//        userVO.setUserName("추가 유저 이름 " + i);
//        userVO.setUserPhoneNumber("추가 유저 폰넘버 " + i);
//        userVO.setUserEmail("user" + i + "@gmail.com");
//
//        userMapper.join(userVO);
//        });
//
//    }

//    회원가입 : 아이디 찾기
//    @Test
//    public void searchIdTest() {
//
//    };

//    마이페이지 : 유저 정보 조회 - 성공
    @Test
    public void getUserDetailTest(){
        Long userNumber = 32L;
        log.info(userMapper.getUserDetail(userNumber).toString());
    }

//    마이페이지 : 유저 정보 수정 - 성공
//    @Test
//    public void updateTest(){
//        Long userNumber = 1L;
//        UserVO userVO = userMapper.getUserDetail(userNumber);
//
//        if(userVO == null) {log.info("NO USER"); return;}
//
//        userVO.setUserEmail("jiyeon1104@nate.com");
//        userVO.setUserName("핑공");
//        userVO.setUserPhoneNumber("01022222222");
//
//        userMapper.update(userVO);
//    }

//    마이페이지 : 비밀번호 수정 - 성공
//    @Test
//    public void updatePwTest(){
//        userMapper.updatePw(1L, "1235");
//    }

//    마이페이지 : 회원 탈퇴 - 성공
//    @Test
//    public void deleteTest(){
//        log.info("DELETE COUNT : " + userMapper.delete(1L));
//    }

// 로그인 - 성공
//    @Test
//    public void loginTest(){
//         UserVO userVO = new UserVO();
//         userVO.setUserId("i");
//         userVO.setUserPw("12345");
//
//         userMapper.login("i", "12345");
//
//    }
}

