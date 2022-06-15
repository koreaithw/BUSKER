package com.example.teamprojeect.mapper;

import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.show.ShowVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShowMapper {
    // 공연 등록
    public void insert(ShowVO showVO);

    // 공연 수정
    public int update(ShowVO showVO);

    // 공연 삭제
    public int delete(Long showNumber);

    // 진행 예정 공연 목록 (등록순 (default), 오늘 이후 날짜만 SELECT)
    public List<ShowVO> getList(Criteria criteria);

    // 진행 예정 공연 목록 (D-DAY 순)
    public List<ShowVO> getListDday(Criteria criteria);

    // 진행 예정 공연 목록 (좋아요 순)
    public List<ShowVO> getListLike(Criteria criteria);

    // 진행 예정 공연 목록 (뮤지션/퍼포먼스 구분)
    public List<ShowVO> getListType(Criteria criteria, String type);

    // 진행 예정 공연 개수 (전체)
    public int getTotalAll();

    // 공연 상세 페이지
    public ShowVO detail(Long showNumber);



    // 진행 중 공연 목록 (오늘 날짜만 SELECT)
    public List<ShowVO> getListToday(Criteria criteria);

    // 진행 중 공연 개수 (전체)
    public int getTotalToday();
}
