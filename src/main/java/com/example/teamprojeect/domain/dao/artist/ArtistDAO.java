package com.example.teamprojeect.domain.dao.artist;

import com.example.teamprojeect.domain.vo.artist.ArtistFileVO;
import com.example.teamprojeect.domain.vo.artist.ArtistVO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.mapper.artist.ArtistMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ArtistDAO {
    private final ArtistMapper artistMapper;

    // 아티스트 정보 //
    // 아티스트 등록 신청 (status 1)
    public void registerApply(ArtistVO artistVO) {
        artistMapper.insertApply(artistVO);
    };

    // 관리자 등록 승인 (status -> 3)
    public void registerAdmin(Long artistNumber){
        artistMapper.insertAdmin(artistNumber);
    }

    // 아티스트 정보 수정 신청 (status 2)
    public boolean modifyApply(ArtistVO artistVO) {
        return artistMapper.updateApply(artistVO) == 1;
    }

    // 관리자 수정 승인 (status -> 3)
    public void modifyAdmin(Long artistNumber) {
        artistMapper.updateAdmin(artistNumber);
    }

    // 아티스트 삭제
    public boolean remove(Long artistNumber) {
        return artistMapper.delete(artistNumber) == 1;
    }

    // 아티스트 목록
    // (매개변수로 artistType을 전달해서 'A'(전체)인지 'M'(아티스트) 인지 'P'(퍼포먼스)인지 구분)
    // (매개변수로 sortingType을 전달해서 '최신순'과 '좋아요순' 구분)
    public List<ArtistVO> getList(@Param("criteria") Criteria criteria, @Param("listDTO") ListDTO listDTO) {
        return artistMapper.getList(criteria, listDTO);
    }
    /*
    artistType likeType (최신, 좋아요 순)
    * * */
    // 아티스트 목록 개수
    // 랭킹 목록 개수
    public int getTotal(ListDTO listDTO) {
        return artistMapper.getTotal(listDTO);
    }

    // 랭킹 //
    // 랭킹 목록
    // (매개변수로 artistType을 전달해서 'A'(전체)인지 'M'(아티스트) 인지 'P'(퍼포먼스)인지 구분)
    // (매개변수로 사용자 클릭에 따른 date를 전달, dateToday로 현재 시간도 전달)
    public List<ArtistVO> rankingList(@Param("criteria") Criteria criteria, @Param("listDTO") ListDTO listDTO) {
        return artistMapper.rankingList(criteria, listDTO);
    }


    // 아티스트 상세 정보
    public ArtistVO getDetail(Long artistNumber) {
        return artistMapper.getDetail(artistNumber);
    }
}
