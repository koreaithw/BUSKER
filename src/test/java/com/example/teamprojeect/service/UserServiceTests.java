package com.example.teamprojeect.service;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.user.LikeVO;
import com.example.teamprojeect.domain.vo.user.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
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

    // 좋아요 등록 (아티스트)
//    @Test
//    public void registerArtistLike(){
//        LikeVO likeVO = new LikeVO();
//
//        likeVO.setUserNumber(24L);
//        likeVO.setArtistNumber(8L);
//
//        userService.registerArtistLike(likeVO);
//        log.info("아티스트 좋아요 등록 성공 + " + likeVO);
//    }

    // 좋아요 등록 (작품)
//    @Test
//    public void registerWorkLikeTest(){
//        LikeVO likeVO = new LikeVO();
//
//        likeVO.setUserNumber(24L);
//        likeVO.setWorkNumber(1L);
//
//        userService.registerWorkLike(likeVO);
//        log.info("작품 좋아요 등록 성공" + likeVO);
//    }

    // 좋아요 취소 (아티스트 + 작품)
//    @Test
//    public void removeLikeTest(){
//        ListDTO listDTO = new ListDTO();
//        listDTO.setLikeCategory("W");
//
//        userService.removeLike(24L, listDTO, 1L);
//        log.info("좋아요 취소 성공");
//    }

    // 좋아요한 아티스트 목록 뽑기
//    @Test
//    public void getLikeArtistTest(){
//        userService.getLikeArtistList(new Criteria(1, 10), 24L, new ListDTO("M", "new", "week", "new", "0")).stream().map(LikeVO::toString).forEach(log::info);
//    }

    // 좋아요한 작품 목록 뽑기
//    @Test
//    public void getWorkListTest(){
//        userService.getLikeWorkList(new Criteria(1, 10), 24L);
//    }

    // 좋아요한 아티스트 수
    @Test
    public void getTotalArtistTest(){
        userService.getTotalArtist(24L, new ListDTO());
    }

    @Test
    public void getTotalWorkTest(){
        userService.getTotalWork(24L);
    }
}
