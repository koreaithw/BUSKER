package com.example.teamprojeect.domain.dao.user;

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

    // 회원가입시 휴대폰 번호 조회 -> 있으면 ID 찾기 실행
    public boolean searchPhoneNumber(String userPhoneNumber) {
        return userMapper.searchPhoneNumber(userPhoneNumber) == null;
    } // null 이면 없는 거

    // 로그인
    public boolean login(@Param("userId") String userId, @Param("userPw") String userPw) {
        return userMapper.login(userId, userPw) == 1;
    }

    // 정보 수정
    public boolean modify(UserVO userVO) {
        return userMapper.update(userVO) == 1;
    }

    // 비밀번호 수정
    public boolean modifyPw(@Param("userNumber") Long userNumber, @Param("password") String password) {
        return userMapper.updatePw(userNumber, password) == 1;
    }

    // 회원 탈퇴
    public boolean remove(UserVO userVO) {
        return userMapper.delete(userVO) == 1;
    }

    // ID, PW 찾기
    public UserVO find(@Param("text") String text, @Param("findWay") String findWay) {
        return userMapper.find(text,findWay);
    }
}
