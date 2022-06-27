package com.example.teamprojeect.domain.dao.show;

import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.show.ShowVO;
import com.example.teamprojeect.mapper.show.ShowMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ShowDAO {
    private final ShowMapper showMapper;

    // 공연 등록
    public void register(ShowVO showVO) {
        showMapper.insert(showVO);
    }

    // 공연 수정
    public boolean modify(ShowVO showVO) {
        return showMapper.update(showVO) == 1;
    }

    // 공연 삭제
    public boolean remove(Long showNumber) {
        return showMapper.delete(showNumber) == 1;
    }

    // 진행 예정 공연 목록
    // (매개변수 기본 : Date가 작은것부터 정렬 (D-day순 정렬))
    // (매개변수 artistType를 받아 전체/뮤지션/퍼포먼스 구분)
    // (매개변수 ingWhether를 받아 진행예정 공연인지 진행중 공연인지 분류, => 오늘 날짜 전달
    // (매개변수 date를 받아 현재 날짜 전송 후 쿼리에서 계산)
    // (진행 중 공연 목록은 date를 이용해 오늘 날짜만 SELECT)
    public List<ShowVO> getList(@Param("criteria") Criteria criteria, @Param("listDTO") ListDTO listDTO) {
        return showMapper.getList(criteria, listDTO);
    }

    // 진행 중 공연 목록
    public List<ShowVO> getListIng(ListDTO listDTO) {
        return showMapper.getListIng(listDTO);
    }

    // 진행 예정 공연 개수
    public int getTotal(ListDTO listDTO) {
        return showMapper.getTotal(listDTO);
    }

    // 진행 중 공연 개수
    public int getTotalIng(ListDTO listDTO) {
        return showMapper.getTotalIng(listDTO);
    }

    // 공연 상세 페이지
    public ShowVO read(Long showNumber) {
        return showMapper.detail(showNumber);
    }

    // 공연 댓글 랭킹
    public List<ShowVO> getRankingReply() { return showMapper. getRankingReply();};
}
