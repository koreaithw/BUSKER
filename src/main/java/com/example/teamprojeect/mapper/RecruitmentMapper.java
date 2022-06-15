package com.example.teamprojeect.mapper;

import com.example.teamprojeect.domain.vo.Criteria;
import com.example.teamprojeect.domain.vo.RecruitmentVO;
import org.apache.ibatis.annotations.Mapper;

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
    public List<RecruitmentVO> getList(Criteria criteria); // 전체목록과 카테고리별 목록 쿼리를 따로 만들어야하는지?
    public List<RecruitmentVO> getList(Criteria criteria, String recruitmentStatus); // 전체 목록은 모든 경우의 status를 출력하는 방식으로?

    // 모집공고 개수 (전체)
    public int getTotal();

    // 모집공고 목록 (뮤지션, 퍼포먼스 구분)
    public List<RecruitmentVO> getListType(Criteria criteria, String recruitmentStatus);

    // 모집공고 상세페이지
    public RecruitmentVO getDetail(Long recruitmentNumber);

    // 모집공고 검색
}
