package com.example.teamprojeect.domain.dao.user;

import com.example.teamprojeect.domain.vo.user.UserFileVO;
import com.example.teamprojeect.mapper.user.UserFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserFileDAO {
    private final UserFileMapper userFileMapper;

    // 프로필 사진 추가
    public void register(UserFileVO userFileVO) {
        userFileMapper.insert(userFileVO);
    }

    // 프로필 사진 삭제
    public void remove(Long userNumber) {
        userFileMapper.delete(userNumber);
    }

    // 프로필 사진 변경
    public void modify(UserFileVO userFileVO) {
        userFileMapper.update(userFileVO);
    }

    // 프로필 사진 선택
    public List<UserFileVO> find(Long userNumber) {
        return userFileMapper.find(userNumber);
    }
}
