package com.example.teamprojeect.mapper.user;

import com.example.teamprojeect.domain.vo.user.UserFileVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserFileMapperTests {

    @Autowired
    private UserFileMapper userFileMapper;

//    마이페이지 회원사진 추가 - 성공
//    @Test
//    public void insertTest(){
//        UserFileVO userFileVO = new UserFileVO();
//        userFileVO.setUserNumber(1L);
//        userFileVO.setUuid("1");
//        userFileVO.setUploadPath("2022/06/17");
//        userFileVO.setFileName("performancer_1.jpeg");
//
//        userFileMapper.insert(userFileVO);
//    }

    // 마이페이지 회원사진 삭제 - 성공
    @Test
    public void deleteTest(){
        userFileMapper.delete(1L);
    }

//    마이페이지 : 프로필 사진 변경-  성공
//    @Test
//    public void updateTest(){
//        UserFileVO userFileVO = new UserFileVO();
//
//        userFileVO.setUserNumber(1L);
//        userFileVO.setFileName("artist_1.jpg");
//        userFileVO.setUuid("2");
//        userFileVO.setUploadPath("2022/06/17");
//
//        userFileMapper.update(userFileVO);
//    }

//    마이페이지 : 프로필 사진 선택 - 성공
//    @Test
//    public void findTest(){
//        userFileMapper.find(1L).stream().map(userFileVO -> toString()).forEach(log::info);
//    }
}
