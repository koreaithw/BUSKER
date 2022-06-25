package com.example.teamprojeect.mapper.show;

import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.show.ShowVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShowMapper {
    // 공연 등록
    public void insert(ShowVO showVO);

    // 공연 수정
    public int update(ShowVO showVO);

    // 공연 삭제
    public int delete(Long showNumber);

    // 진행 예정 공연 목록
    // (매개변수 기본 : Date가 작은것부터 정렬 (D-day순 정렬))
    // (매개변수 artistType를 받아 전체/뮤지션/퍼포먼스 구분)
    // (매개변수 ingWhether를 받아 진행예정 공연인지 진행중 공연인지 분류, => 오늘 날짜 전달
    // (매개변수 dateToday를 받아 현재 날짜 전송 후 쿼리에서 계산)
    // (진행 중 공연 목록은 dateToday를 이용해 오늘 날짜만 SELECT)
    public List<ShowVO> getList(@Param("criteria") Criteria criteria, @Param("listDTO") ListDTO listDTO);

    // 진행 중 공연 목록
//    public List<ShowVO> getListIng(@Param("criteria") Criteria criteria, @Param("listDTO") ListDTO listDTO);
    public List<ShowVO> getListIng(ListDTO listDTO);

    // 진행 예정 공연 개수
    public int getTotal(ListDTO listDTO);

    // 진행 중 공연 개수
    public int getTotalIng(ListDTO listDTO);

    // 공연 상세 페이지
    public ShowVO detail(Long showNumber);

    // 공연 댓글 랭킹
    public List<ShowVO> getRankingReply();
}
