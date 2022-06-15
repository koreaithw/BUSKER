package com.example.teamprojeect.mapper;

import com.example.teamprojeect.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // 회원가입
    public void join(UserVO userVO);
    // 회원가입시 휴대폰 번호 조회 -> 있으면 ID 찾기
    public boolean searchPhoneNumber(String userPhoneNumber);
    // boolean 리턴값은 try catch문으로 잡아야 하는건가?

    // 로그인
    public int login(String userId, String userPw);

    // 정보 수정
    public int update(UserVO userVO);

    // 비밀번호 수정
    public int updatePw(Long userNUmber, String password);

    // 회원 탈퇴
    public int delete(UserVO userVO);

    // ID, PW 찾기
    public List<UserVO> find(UserVO userVO);
}
