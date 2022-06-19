package com.example.teamprojeect.domain.dao.user;
import com.example.teamprojeect.domain.vo.user.UserFileVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserFileDaoTests {
    @Autowired
    private UserFileDAO userFileDAO;

//    마이페이지 : 프로필 사진 추가
//    @Test
//    public void registerTest(){
//        UserFileVO userFileVO = new UserFileVO();
//
//        userFileVO.setUserNumber(1L);
//        userFileVO.setUuid("파일 DAO 테스트");
//        userFileVO.setUploadPath("DAO 테스트 DAO테스트");
//        userFileVO.setFileName("파일 이름 DAO 테스트");
//
//        userFileDAO.register(userFileVO);
//    }

//    마이페이지 : 프로필 사진 변경 - 성공
//    @Test
//    public void modifyTest(){
//        UserFileVO userFileVO = new UserFileVO();
//
//        userFileVO.setUserNumber(1L);
//        userFileVO.setUuid("파일 변경 DAO 테스트");
//        userFileVO.setUploadPath("변경 DAO 변경 DAO");
//        userFileVO.setFileName("파일 이름 변경 DAO");
//
//        userFileDAO.modify(userFileVO);
//    }

//    마이페이지 프로필 사진 선택 - 성공
//    @Test
//    public void findTest(){
//        Long userNumber= 1L;
//        userFileDAO.find(userNumber).stream().map(userFileVO -> toString()).forEach(log::info);
//    }

//    마이페이지 프로필 사진 삭제
//    @Test
//    public void removeTest(){
//        Long userNumber= 1L;
//        userFileDAO.remove(userNumber);
//
//        log.info("프로필 사진 삭제 성공");
//    }
}
