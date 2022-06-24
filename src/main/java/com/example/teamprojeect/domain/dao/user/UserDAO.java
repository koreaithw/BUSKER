package com.example.teamprojeect.domain.dao.user;

import com.example.teamprojeect.domain.vo.list.UserListDTO;
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

    // 회원가입시 휴대폰 번호 조회 -> 있으면 ID 찾기 실행
    public boolean searchPhoneNumber(String userPhoneNumber) {
        return userMapper.searchPhoneNumber(userPhoneNumber) == null;
    } // null 이면 없는 거

    // 로그인
    public boolean login(@Param("userId") String userId, @Param("userPw") String userPw) {
        return userMapper.login(userId, userPw) == 1;
    }

    // ID, PW 찾기
    public UserVO find(@Param("text") String text, @Param("findWay") String findWay) {
        return userMapper.find(text,findWay);
    }

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
    public List<UserVO> getUserList(@Param("criteria") Criteria criteria, @Param("userListDTO") UserListDTO userListDTO) {
        return userMapper.getUserList(criteria, userListDTO);
    }

    // 관리자 페이지 : 총 유저 수
    public int getTotal() {
        return userMapper.getTotal();
    }
}
