package com.example.teamprojeect.mapper.user;

import com.example.teamprojeect.domain.vo.user.UserFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserFileMapper {
    // 프로필 사진 추가 > 완료
    public void insert(UserFileVO userFileVO);

    // 프로필 사진 삭제 > 완료
    public void delete(Long userNumber);

    // 프로필 사진 변경 - 삭제 고려 / UUID가 PRIMARY KEY이고 CONTROLLER에 의해 랜덤으로 바뀌기 때문에 특정할 수 없음
    public void update(UserFileVO userFileVO);

    // 프로필 사진 선택 > 완료
    public List<UserFileVO> find(Long userNumber);
}
