package com.example.teamprojeect.service;

import com.example.teamprojeect.domain.dao.artist.ArtistDAO;
import com.example.teamprojeect.domain.dao.artist.ArtistFileDAO;
import com.example.teamprojeect.domain.dao.artist.ArtistReplyDAO;
import com.example.teamprojeect.domain.dao.artist.PaymentDAO;
import com.example.teamprojeect.domain.dao.user.LikeDAO;
import com.example.teamprojeect.domain.vo.artist.ArtistReplyVO;
import com.example.teamprojeect.domain.vo.artist.ArtistVO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.show.ShowReplyVO;
import com.example.teamprojeect.domain.vo.show.ShowVO;
import com.example.teamprojeect.mapper.artist.ArtistMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtistService {
    //필드
    private final ArtistDAO artistDAO;
    private final ArtistFileDAO artistFileDAO;
    private final ArtistReplyDAO artistReplyDAO;
    private final LikeDAO likeDAO;
    private final PaymentDAO paymentDAO;
    private final ArtistMapper artistMapper;
    private final ListDTO listDTO;



    //아티스트 전체목록
    public List<ArtistVO> getList(Criteria criteria, ListDTO listDTO) {
        return artistDAO.getList(criteria, listDTO);
    }
    //아티스트 뮤지션 목록
    public List<ArtistVO> getListMusician(@Param("listDTO") ListDTO listDTO) {
        return artistMapper.getListMusician(listDTO);
    }
    //아티스트 퍼포먼스 목록
    public List<ArtistVO> getListPeformance(@Param("listDTO") ListDTO listDTO) {
        return artistMapper.getListPerformance(listDTO);
    }

    //아티스트 갯수
    public int getTotal(ListDTO listDTO) {
        return artistMapper.getTotal(listDTO);
    }

    //아티스트 상세정보
    public ArtistVO getDetail(Long artistNumber) {
        return artistDAO.getDetail(artistNumber);
    }

    public void registerReply(ArtistReplyVO artistReplyVO) {
        artistReplyDAO.register(artistReplyVO);
    }

    public boolean modifyReply(ArtistReplyVO artistReplyVO) {
        return artistReplyDAO.modify(artistReplyVO);
    }

    public boolean removeReply(Long replyNumber) {
        return artistReplyDAO.remove(replyNumber);
    }

    public int getTotalReply(Long artistNumber) {
        return artistReplyDAO.getTotal(artistNumber);
    }

    public List<ArtistReplyVO> getListReply(Criteria criteria, Long showNumber) {
        return  artistReplyDAO.getList(criteria, showNumber);
    }


}
