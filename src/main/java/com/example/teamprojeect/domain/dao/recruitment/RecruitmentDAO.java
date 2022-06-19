package com.example.teamprojeect.domain.dao.recruitment;

import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.recruitment.RecruitmentVO;
import com.example.teamprojeect.mapper.recruitment.RecruitmentMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RecruitmentDAO {
    private final RecruitmentMapper recruitmentMapper;

    // 모집공고 등록
    public void register(RecruitmentVO recruitmentVO) {
        recruitmentMapper.insert(recruitmentVO);
    }

    // 모집공고 수정
    public boolean modify(RecruitmentVO recruitmentVO) {
        return recruitmentMapper.update(recruitmentVO) == 1;
    }

    // 모집공고 삭제
    public boolean remove(Long recruitmentNumber) {
        return recruitmentMapper.delete(recruitmentNumber) == 1;
    }

    // 모집공고 목록 (전체)
    // 모집공고 목록 (뮤지션, 퍼포먼스 구분)
    public List<RecruitmentVO> getList(@Param("criteria") Criteria criteria, @Param("listDTO") ListDTO listDTO) {
        return recruitmentMapper.getList(criteria, listDTO);
    } // 전체 목록은 모든 경우의 status를 출력하는 방식으로?

    // 모집공고 개수 (전체)
    public int getTotal(ListDTO listDTO) {
        return recruitmentMapper.getTotal(listDTO);
    }

    // 모집공고 상세페이지
    public RecruitmentVO getDetail(Long recruitmentNumber) {
        return recruitmentMapper.getDetail(recruitmentNumber);
    }

}
