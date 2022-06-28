package com.example.teamprojeect.domain.dao.recruitment;

import com.example.teamprojeect.domain.vo.recruitment.RecruitmentFileVO;
import com.example.teamprojeect.mapper.recruitment.RecruitmentFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RecruitmentFileDAO {
    private final RecruitmentFileMapper recruitmentFileMapper;

    // 모집공고 사진 추가
    public void register(RecruitmentFileVO recruitmentFileVO) {
        recruitmentFileMapper.insert(recruitmentFileVO);
    }

    // 모집공고 사진 삭제
    public void remove(Long recruitmentNumber) {
        recruitmentFileMapper.delete(recruitmentNumber);
    }

    // 모집공고 사진 선택
    public RecruitmentFileVO find(Long recruitmentNumber) {
        return recruitmentFileMapper.find(recruitmentNumber);
    }
}
