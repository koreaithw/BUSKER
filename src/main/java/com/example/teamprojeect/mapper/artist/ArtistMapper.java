package com.example.teamprojeect.mapper.artist;

import com.example.teamprojeect.domain.vo.artist.ArtistVO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArtistMapper {
    // 아티스트 정보 //
    // 아티스트 등록 신청 (status 1)
    public void insertApply(ArtistVO artistVO);

    // 관리자 등록 승인 (status -> 3)
    public void insertAdmin(Long artistNumber);

    // 아티스트 정보 수정 신청 (status 2)
    public int updateApply(ArtistVO artistVO);

    // 관리자 수정 승인 (status -> 3)
    public void updateAdmin(Long artistNumber);

    // 아티스트 삭제
    public int delete(Long artistNumber);

    // 아티스트 목록
    // (매개변수로 artistType을 전달해서 'A'(전체)인지 'M'(아티스트) 인지 'P'(퍼포먼스)인지 구분)
    // (매개변수로 sortingType을 전달해서 '최신순'과 '좋아요순' 구분)
    public List<ArtistVO> getList(@Param("criteria") Criteria criteria, @Param("listDTO") ListDTO listDTO);
/*
artistType likeType (최신, 좋아요 순)
* * */
    // 아티스트 목록 개수
    // 랭킹 목록 개수
    public int getTotal(ListDTO listDTO);

    // 랭킹 //
    // 랭킹 목록
    // (매개변수로 artistType을 전달해서 'A'(전체)인지 'M'(아티스트) 인지 'P'(퍼포먼스)인지 구분)
    // (매개변수로 사용자 클릭에 따른 date를 전달, dateToday로 현재 시간도 전달)
    public List<ArtistVO> rankingList(@Param("criteria") Criteria criteria, @Param("listDTO") ListDTO listDTO);


    // 아티스트 상세 정보
    public ArtistVO getDetail(Long artistNumber);
}
