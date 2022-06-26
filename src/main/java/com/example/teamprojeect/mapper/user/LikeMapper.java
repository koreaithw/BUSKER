package com.example.teamprojeect.mapper.user;

import com.example.teamprojeect.domain.vo.artist.ArtistVO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.user.LikeVO;
import com.example.teamprojeect.domain.vo.work.WorkVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LikeMapper {
    // 좋아요 (아티스트) 등록
    public void insertArtistLike(LikeVO likeVO);

    // 좋아요 (아티스트) 삭제
    public void deleteArtistLike(LikeVO likeVO);

    // 좋아요 (작품) 등록
    public void insertWorkLike(LikeVO likeVO);

    // 좋아요 취소
    // (매개변수로 likeCategory를 전달해서 'A'(아티스트) 인지 'W'(작품)인지 구분)
    // (매개변수로 typeNumber를 전달해서 해당 type의 number를 입력)
    public int delete(@Param("userNumber") Long userNumber, @Param("listDTO") ListDTO listDTO, @Param("number") Long number);

    // 좋아요 목록
    // (매개변수로 likeType를 전달해서 'A'(아티스트) 인지 'W'(작품)인지 구분)
    public List<LikeVO> getLikeArtistList(@Param ("criteria") Criteria criteria, @Param("userNumber") Long userNumber, @Param("listDTO") ListDTO listDTO);
    public List<LikeVO> getLikeWorkList(@Param ("criteria") Criteria criteria, @Param("userNumber") Long userNumber);

    // 아티스트 좋아요 개수
    public int getTotalArtist(@Param("userNumber") Long userNumber, @Param("listDTO") ListDTO listDTO);

    // 작품 좋아요 개수
    public int getTotalWork(Long userNumber);

    // 아티스트, 작품의 좋아요 개수 (매개변수로 likeCategory를 전달해서 'A'(아티스트) 인지 'W'(작품)인지 구분)
//    public int getTotal(@Param("number") Long number, @Param("listDTO") ListDTO listDTO) {
//        return likeMapper.getTotal(number, listDTO);
//    }
}
