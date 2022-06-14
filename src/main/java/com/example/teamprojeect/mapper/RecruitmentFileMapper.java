package com.example.teamprojeect.mapper;

import com.example.teamprojeect.domain.vo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecruitmentFileMapper {
    // 모집공고 사진 추가
    public void insert(RecruitmentFileVO recruitmentFileVO);

    // 모집공고 사진 삭제
    public void delete(Long recruitmentNumber);

    // 모집공고 사진 변경
    public void update(RecruitmentFileVO recruitmentFileVO);

    // 모집공고 사진 선택
    public List<RecruitmentFileVO> find(Long recruitmentNumber);
}