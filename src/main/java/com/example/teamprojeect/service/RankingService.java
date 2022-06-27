package com.example.teamprojeect.service;

import com.example.teamprojeect.domain.dao.artist.ArtistDAO;
import com.example.teamprojeect.domain.dao.artist.ArtistFileDAO;
import com.example.teamprojeect.domain.dao.artist.ArtistReplyDAO;
import com.example.teamprojeect.domain.dao.artist.PaymentDAO;
import com.example.teamprojeect.domain.dao.user.LikeDAO;
import com.example.teamprojeect.domain.vo.artist.ArtistDTO;
import com.example.teamprojeect.domain.vo.artist.ArtistVO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.mapper.artist.ArtistMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RankingService {
    //필드
    private final ArtistDAO artistDAO;
    private final ArtistFileDAO artistFileDAO;
    private final ArtistReplyDAO artistReplyDAO;
    private final LikeDAO likeDAO;
    private final PaymentDAO paymentDAO;
    private final ArtistMapper artistMapper;
    private final ListDTO listDTO;
    public String rankingListAll;
    public String rankingListMusician;
    public String rankingListPerformance;


    //아티스트 전체목록
    public List<ArtistVO> getList(Criteria criteria, ListDTO listDTO) {
        return artistDAO.getList(criteria, listDTO);
    }
    //아티스트 뮤지션 목록
    public List<ArtistVO> getListMusician(Criteria criteria, ListDTO listDTO) {
        return artistDAO.getList(criteria, listDTO);
    }
    //아티스트 퍼포먼스 목록
    public List<ArtistVO> getListPeformance(Criteria criteria, ListDTO listDTO) {
        return artistDAO.getList(criteria, listDTO);
    }

    //아티스트 갯수
    public int getTotal(ListDTO listDTO) {
        return artistMapper.getTotal(listDTO);
    }

    //아티스트 상세정보
    public ArtistVO getDetail(Long artistNumber) {
        return artistDAO.getDetail(artistNumber);
    }

    //랭킹 목록
    public List<ArtistDTO> rankingListAll(Criteria criteria, ListDTO listDTO) {
        return artistDAO.rankingListAll(criteria, listDTO);
    }

    //뮤지션 랭킹 목록
    public List<ArtistDTO> rankingListMusician(Criteria criteria, ListDTO listDTO) {
        return artistDAO.rankingListMusician(criteria, listDTO);
    }

    //퍼포먼스 랭킹 목록
    public List<ArtistDTO> rankingListPerformance(Criteria criteria, ListDTO listDTO) {
        return artistDAO.rankingListPerformance(criteria, listDTO);
    }








}
