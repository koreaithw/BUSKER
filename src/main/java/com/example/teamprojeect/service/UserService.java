package com.example.teamprojeect.service;

import com.example.teamprojeect.domain.dao.user.LikeDAO;
import com.example.teamprojeect.domain.dao.user.UserDAO;
import com.example.teamprojeect.domain.dao.user.UserFileDAO;
import com.example.teamprojeect.domain.vo.user.UserFileVO;
import com.example.teamprojeect.domain.vo.user.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDAO userDAO;
    private final UserFileDAO userFileDAO;
    private final LikeDAO likeDAO;

    // 마이페이지 : 유저 정보 조회
    public UserVO read(Long userNumber){return userDAO.read(userNumber);}

    // 마이페이지 : 유저 정보 수정
    public boolean modify(UserVO userVO){
        return userDAO.modify(userVO);
    }

    // 마이페이지 : 비밀번호 수정
    public boolean modifyPw(Long userNumber, String password){
        return userDAO.modifyPw(userNumber, password);
    }

    // 마이페이지 : 회원탈퇴
    public boolean remove(Long userNumber){
        return userDAO.remove(userNumber);
    }

    // 로그인
    public boolean login(String userId, String userPw) {return userDAO.login(userId,userPw);}


}
