package com.example.teamprojeect.mapper.user;

import com.example.teamprojeect.domain.vo.user.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void joinTest() {
        UserVO userVO = new UserVO();

        userVO.setUserId("tndus");
        userVO.setUserPw("1234");
        userVO.setUserName("왕고옹");
        userVO.setUserPhoneNumber("01011111111");
        userVO.setUserEmail("수연@naver.com");

        userMapper.join(userVO);

        log.info("회원 가입 성공 " + userVO.getUserNumber());
        log.info("회원 가입 성공 " + userVO.getUserNumber());
        log.info("회원 가입 성공 " + userVO.getUserNumber());
        log.info("회원 가입 성공 " + userVO.getUserNumber());
    }

    @Test
    public void searchIdTest() {

    };


}

