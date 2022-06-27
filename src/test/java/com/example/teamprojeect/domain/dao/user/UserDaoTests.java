package com.example.teamprojeect.domain.dao.user;
import com.example.teamprojeect.domain.vo.user.UserVO;
import com.example.teamprojeect.mapper.user.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserDaoTests {
    @Autowired
    private UserDAO userDAO;

//    마이페이지 정보 조회 테스트
//    @Test
//    public void readTest(){
//        Long userNumber = 3L;
//        log.info(userDAO.read(userNumber).toString());
//    }

//    마이페이지 정보 수정 테스트 - 성공
//    @Test
//    public void modifyTest(){
//        UserVO userVO = new UserVO();
//
//        userVO.setUserNumber(2L);
//        userVO.setUserName("덤보");
//        userVO.setUserPhoneNumber("01033333333");
//        userVO.setUserEmail("2018110325@dgu.ac.kr");
//        userVO.setUserArtistStatus(3L);
//
//        userDAO.modify(userVO);
//    }

//    마이페이지 비밀번호 수정 - 성공
//    @Test
//    public void modifyPwTest(){
//        Long userNumber = 2L;
//
//        userDAO.modifyPw(userNumber, "4567");
//        log.info("비밀번호 수정 성공");
//    }

//    마이페이지 회원 탈퇴 - 성공
//    @Test
//    public void removeTest(){
//        userDAO.remove(2L);
//        log.info("회원 탈퇴 완료");
//    }

// 로그인
    @Test
    public void loginTest(){
        userDAO.login("tndus", "1234");
    }
    // 유저 리스트
//    @Test
//    public void getUserListTest() {
//        Criteria criteria = new Criteria(2,10);
//        UserListDTO userListDTO = new UserListDTO();
//        userDAO.getUserList(criteria, userListDTO).stream().map(UserVO::toString).forEach(log::info);
//    }

    // 총 유저 수
    @Test
    public void getTotalTest() {
        userDAO.getTotal();
    }
}
