package com.example.teamprojeect.mapper.user;

import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.user.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    // 회원가입
    public void join(UserVO userVO);

    // 회원가입시 휴대폰 번호 조회 -> 있으면 ID 찾기 실행
    public String searchPhoneNumber(String userPhoneNumber); // null 이면 없는 거

    // 회원가입시 아이디 조회 -> 있으면 ID 찾기 실행
    public String searchId(String userId); // null 이면 없는 거

    // 회원가입 : ID, PW 찾기
    public UserVO find(@Param("text") String text, @Param("findWay") String findWay);

    // 로그인
    public int login(@Param("userId") String userId, @Param("userPw") String userPw);

    // 마이페이지 : 정보 조회 > 완료
    public UserVO getUserDetail(Long userNumber);

    // 마이페이지 : 정보 수정 > 완료
    public int update(UserVO userVO);

    // 마이페이지 : 비밀번호 수정 > 완료
    public int updatePw(@Param("userNumber") Long userNumber, @Param("password") String password);

    // 마이페이지 : 회원 탈퇴
    public int delete(Long userNumber);

    // 마이페이지 : 아티스트 계정 등록삭제 (
    public int updateArtist(@Param("userNumber") Long userNumber, @Param("listDTO") ListDTO listDTO);

}
