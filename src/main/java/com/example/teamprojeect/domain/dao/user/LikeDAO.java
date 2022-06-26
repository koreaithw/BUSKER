package com.example.teamprojeect.domain.dao.user;

import com.example.teamprojeect.domain.vo.artist.ArtistVO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.user.LikeVO;
import com.example.teamprojeect.mapper.user.LikeMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LikeDAO {
    private final LikeMapper likeMapper;

    // 좋아요 등록 (아티스트)
    public void registerArtistLike(LikeVO likeVO) {
        likeMapper.insertArtistLike(likeVO);
    }

    // 좋아요 등록 (아티스트)
    public void removeArtistLike(LikeVO likeVO) {
        likeMapper.deleteArtistLike(likeVO);
    }

    // 좋아요 등록 (작품)
    public void registerWorkLike(LikeVO likeVO){
        likeMapper.insertWorkLike(likeVO);
    }

    // 좋아요 취소
    // (매개변수로 likeType를 전달해서 'A'(아티스트) 인지 'W'(작품)인지 구분)
    // (매개변수로 typeNumber를 전달해서 해당 type의 number를 입력)
    public boolean removeLike(@Param("userNumber") Long userNumber, @Param("listDTO") ListDTO listDTO, @Param("number") Long number) {
        return likeMapper.delete(userNumber, listDTO, number) == 1;
    }

    // 좋아요 아티스트 목록
    // (매개변수로 likeType를 전달해서 'A'(아티스트) 인지 'W'(작품)인지 구분)
    public List<LikeVO> getLikeArtistList(@Param ("criteria") Criteria criteria, @Param("userNumber") Long userNumber, @Param("listDTO") ListDTO listDTO) {
        return likeMapper.getLikeArtistList(criteria, userNumber, listDTO);
    }

    // 좋아요 작품 목록
    public List<LikeVO> getLikeWorkList(@Param ("criteria") Criteria criteria, @Param("userNumber") Long userNumber){
        return likeMapper.getLikeWorkList(criteria, userNumber);
    }

    // 아티스트, 작품의 좋아요 개수 (매개변수로 likeCategory를 전달해서 'A'(아티스트) 인지 'W'(작품)인지 구분)
//    public int getTotal(@Param("number") Long number, @Param("listDTO") ListDTO listDTO) {
//        return likeMapper.getTotal(number, listDTO);
//    }

    // 내가 좋아요한 아티스트 수
    public int getTotalArtist(@Param("userNumber") Long userNumber, @Param("listDTO") ListDTO listDTO){
        return likeMapper.getTotalArtist(userNumber, listDTO);
    }

    // 내가 좋아요한 작품 수
    public int getTotalWork(Long userNumber){
        return likeMapper.getTotalWork(userNumber);
    }
}
