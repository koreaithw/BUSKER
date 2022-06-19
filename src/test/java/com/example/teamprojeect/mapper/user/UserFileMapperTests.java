package com.example.teamprojeect.mapper.user;

import com.example.teamprojeect.domain.vo.user.UserFileVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Slf4j
public class UserFileMapperTests {

    @Autowired
    private UserFileMapper userFileMapper;

//    마이페이지 회원사진 추가 - 성공
//    @Test
//    public void insertTest(){
//        IntStream.rangeClosed(3,32).forEach(i -> {
//        UserFileVO userFileVO = new UserFileVO();
//
//        userFileVO.setUserNumber(Long.valueOf(i));
//        userFileVO.setUuid("fileUuid" + i);
//        userFileVO.setUploadPath("2022/06/17");
//        userFileVO.setFileName("file" + i + "jpeg");
//
//        userFileMapper.insert(userFileVO);
//    });
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
