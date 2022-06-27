package com.example.teamprojeect.domain.dao.user;

import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.user.UserVO;
import com.example.teamprojeect.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final UserMapper userMapper;

    // 회원가입
    public void join(UserVO userVO) {
        userMapper.join(userVO);
    }

    // 카카오 회원가입
    public void kakaoJoin(UserVO userVO) { userMapper.kakaoJoin(userVO);}

    // 카카오 회원가입
    public Long kakaoLogin(String userId) { return userMapper.kakaoLogin(userId);}


    // 회원가입시 휴대폰 번호 조회 -> 있으면 ID 찾기 실행
    public boolean searchPhoneNumber(String userPhoneNumber) {
        return userMapper.searchPhoneNumber(userPhoneNumber) == null;
    } // null 이면 없는 거

    // 로그인
    public Long login(@Param("userId") String userId, @Param("userPw") String userPw) {
        return userMapper.login(userId, userPw);
    }

    // 아이디 중복 검사
    public String searchId(String userId) {
        return userMapper.searchId(userId);
    }; // null 이면 없는 거

    // ID, PW 찾기
    public UserVO find(String text) {
        return userMapper.find(text);
    }

    // ID, PW 찾기
    public Long findCount(String text) {
        return userMapper.findCount(text);
    }
    public Long findPwCount(UserVO userVO) { return userMapper.findPwCount(userVO); };
    // 마이페이지 : 정보 조회
    public UserVO read(Long userNumber) {return userMapper.getUserDetail(userNumber);}

    // 마이페이지 : 정보 수정
    public boolean modify(UserVO userVO) {
        return userMapper.update(userVO) == 1;
    }

    // 마이페이지 : 비밀번호 수정
    public boolean modifyPw(@Param("userNumber") Long userNumber, @Param("password") String password) {
        return userMapper.updatePw(userNumber, password) == 1;
    }

    // 마이페이지 : 회원 탈퇴
    public boolean remove(Long userNumber) {
        return userMapper.delete(userNumber) == 1;
    }

    // 관리자 페이지 : 유저 리스트
    public List<UserVO> getUserList(@Param("criteria") Criteria criteria, @Param("isArtist") boolean isArtist) {
        return userMapper.getUserList(criteria, isArtist);
    }

    // 관리자 페이지 : 총 유저 수
    public int getTotal() {
        return userMapper.getTotal();
    }

    // 관리자 페이지 : 아티스트로 등록된 유저 수
    public int getArtistotal() {
        return userMapper.getArtistTotal();
    }

    // 관리자 페이지 : 검색 결과 개수
    public int getSearchTotal(Criteria criteria) {
        return userMapper.getSearchTotal(criteria);
    }
}
