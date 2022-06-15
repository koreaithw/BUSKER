package com.example.teamprojeect.mapper.user;

import com.example.teamprojeect.domain.vo.user.UserFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserFileMapper {
    // 프로필 사진 추가
    public void insert(UserFileVO userFileVO);

    // 프로필 사진 삭제
    public void delete(Long userNumber);

    // 프로필 사진 변경
    public void update(UserFileVO userFileVO);

    // 프로필 사진 선택
    public List<UserFileVO> find(Long userNumber);
}
