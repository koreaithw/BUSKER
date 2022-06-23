package com.example.teamprojeect.mapper.user;

import com.example.teamprojeect.domain.vo.artist.ArtistVO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.user.LikeVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class LikeMapperTests {
    @Autowired
    private LikeMapper likeMapper;

//    좋아요 등록 (아티스트) 테스트 - 성공
//    @Test
//    public void insertArtistLike(){
//        LikeVO likeVO = new LikeVO();
//
//        likeVO.setUserNumber(1L);
//        likeVO.setArtistNumber(1L);
//
//        likeMapper.insertArtistLike(likeVO);
//        log.info("아티스트 좋아요 등록 성공 + " + likeVO);
//    }

//    좋아요 등록 (작품) 테스트 - 성공
//    @Test
//    public void insertWorkLike(){
//        LikeVO likeVO = new LikeVO();
//
//        likeVO.setUserNumber(2L);
//        likeVO.setWorkNumber(1L);
//
//        likeMapper.insertWorkLike(likeVO);
//        log.info("작품 좋아요 등록 성공" + likeVO);
//    }

    // 좋아요 취소 테스트 - 성공
//    @Test
//    public void deleteTest(){
//        ListDTO listDTO = new ListDTO();
//        listDTO.setLikeCategory("A");
//
//        likeMapper.delete(1L, listDTO, 1L);
//        log.info("좋아요 취소 성공");
//    }

    // 좋아요 아티스트 목록
    @Test
    public void getLikeArtistTest(){
        likeMapper.getLikeArtistList(new Criteria(1, 10), 24L, new ListDTO("M", "new", "week", "new", "0")).stream().map(LikeVO::toString).forEach(log::info);
    }

    // 좋아요 작품 목록
//    @Test
//    public void getWorkListTest(){
//        likeMapper.getLikeWorkList(new Criteria(1, 10), 24L);
//    }

    // 좋아요 아티스트 전체 개수
    @Test
    public void getTotalArtistTest(){
        ListDTO listDTO = new ListDTO();
        Long userNumber = 24L;
        listDTO.setArtistType("M");
        likeMapper.getTotalArtist(userNumber, listDTO);

    }

    // 좋아요 작품 개수
    @Test
    public void getTotalWorkTest(){
        Long userNumber = 24L;
        likeMapper.getTotalWork(userNumber);
    }

}
