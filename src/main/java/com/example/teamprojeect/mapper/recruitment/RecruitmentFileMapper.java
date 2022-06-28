package com.example.teamprojeect.mapper.recruitment;

import com.example.teamprojeect.domain.vo.recruitment.RecruitmentFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecruitmentFileMapper {
    // 모집공고 사진 추가
    public void insert(RecruitmentFileVO recruitmentFileVO);

    // 모집공고 사진 삭제
    public void delete(Long recruitmentNumber);

    // 모집공고 사진 선택
    public RecruitmentFileVO find(Long recruitmentNumber);
}
