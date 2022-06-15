package com.example.teamprojeect.mapper;

import com.example.teamprojeect.domain.vo.artist.ArtistVO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArtistMapper {
    // 아티스트 등록 신청
    public void insertApply(ArtistVO artistVO);

    // 아티스트 정보 수정 신청
    public int updateApply(ArtistVO artistVO);

    // 아티스트 삭제
    public int delete(Long artistNumber);

    // 아티스트 전체 개수
    public int getTotal();

    // 아티스트 목록 (전체)
    public List<ArtistVO> getListAll(Criteria criteria);

    // 아티스트 목록 (뮤지션, 퍼포먼스 구분)
    public List<ArtistVO> getListType(Criteria criteria, Long artistType);

    // 아티스트 상세 정보
    public ArtistVO getDetail(Long artistNumber);

    // 아티스트 검색

}
