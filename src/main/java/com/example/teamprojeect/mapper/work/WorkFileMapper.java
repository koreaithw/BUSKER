package com.example.teamprojeect.mapper.work;

import com.example.teamprojeect.domain.vo.work.WorkFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkFileMapper {
    // 작품 사진 추가
    public void insert(WorkFileVO workFileVO);

    // 작품 사진 삭제
    public void delete(Long workNumber);

    // 작품 사진 선택
    public WorkFileVO find(Long workNumber);
}
