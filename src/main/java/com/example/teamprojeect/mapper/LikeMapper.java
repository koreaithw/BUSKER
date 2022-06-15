package com.example.teamprojeect.mapper;

import com.example.teamprojeect.domain.vo.artist.ArtistVO;
import com.example.teamprojeect.domain.vo.user.LikeVO;
import com.example.teamprojeect.domain.vo.work.WorkVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LikeMapper {
    // 좋아요 등록
    public void insert(LikeVO likeVO);

    // 좋아요 취소
    public int deleteArtistLike(Long userNumber, Long artistNumber);
    public int deleteShowLike(Long userNumber, Long showNumber);
    public int deleteWorkLike(Long userNumber, Long workNumber);

    // 마이페이지 좋아요 아티스트 목록
    public List<ArtistVO> getListLikeArtist(Long userNumber); // usreNumber가 맞으면서 like_category가 'A'인 컬럼 찾기

    // 마이페이지 좋아요 작품 목록
    public List<WorkVO> getListLikeWork(Long userNumber); // usreNumber가 맞으면서 like_category가 'W'인 컬럼 찾기


    // 아티스트의 좋아요 개수
    public int getArtistLike(Long artistNumber);

    // 공연의 좋아요 개수
    public int getShowLike(Long showNumber);

    // 작품의 좋아요 개수
    public int getWorkLike(Long workNumber);
}
