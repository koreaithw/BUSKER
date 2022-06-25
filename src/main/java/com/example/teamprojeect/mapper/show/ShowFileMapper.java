package com.example.teamprojeect.mapper.show;

import com.example.teamprojeect.domain.vo.show.ShowFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShowFileMapper {
    // 공연 사진 추가
    public void insert(ShowFileVO showFileVO);

    // 공연 사진 삭제
    public void delete(Long showNumber);

    // 공연 사진 선택
    public ShowFileVO find(Long showNumber);
}
