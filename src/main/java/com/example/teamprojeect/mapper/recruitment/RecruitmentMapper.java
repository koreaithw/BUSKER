package com.example.teamprojeect.mapper.recruitment;

import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.recruitment.RecruitmentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecruitmentMapper {
    // 모집공고 등록
    public void insert(RecruitmentVO recruitmentVO);

    // 모집공고 수정
    public int update(RecruitmentVO recruitmentVO);

    // 모집공고 삭제
    public int delete(Long recruitmentNumber);

    // 모집공고 목록 (전체)
    // 모집공고 목록 (뮤지션, 퍼포먼스 구분)
    public List<RecruitmentVO> getList(@Param("criteria") Criteria criteria, @Param("listDTO") ListDTO listDTO); // 전체 목록은 모든 경우의 status를 출력하는 방식으로?

    // 모집공고 개수 (전체)
    public int getTotal(ListDTO listDTO);


    // 모집공고 상세페이지
    public RecruitmentVO getDetail(Long recruitmentNumber);

    // 모집공고 검색
}
