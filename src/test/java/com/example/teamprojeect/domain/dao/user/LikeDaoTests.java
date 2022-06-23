package com.example.teamprojeect.domain.dao.user;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.user.LikeVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class LikeDaoTests {
    @Autowired
    private LikeDAO likeDAO;

    // 좋아요 등록 (아티스트) - 성공
//    @Test
//    public void registerArtistLikeTest(){
//        LikeVO likeVO = new LikeVO();
//
//        likeVO.setUserNumber(24L);
//        likeVO.setArtistNumber(8L);
//
//        likeDAO.registerArtistLike(likeVO);
//        log.info("아티스트 좋아요 등록 성공 + " + likeVO);
//    }

    // 좋아요 등록 (작품) - 성공
//    @Test
//    public void registerWorkLikeTest(){
//        LikeVO likeVO = new LikeVO();
//
//        likeVO.setUserNumber(24L);
//        likeVO.setWorkNumber(1L);
//
//        likeDAO.registerWorkLike(likeVO);
//        log.info("작품 좋아요 등록 성공" + likeVO);
//    }

    // 좋아요 취소 테스트 - 성공
//    @Test
//    public void removeLikeTest(){
//        ListDTO listDTO = new ListDTO();
//        listDTO.setLikeCategory("W");
//
//        likeDAO.remove(24L, listDTO, 1L);
//        log.info("좋아요 취소 성공");
//    }

    // 좋아요한 아티스트 목록 - 성공
//    @Test
//    public void getLikeArtistTest(){
//        likeDAO.getLikeArtistList(new Criteria(1, 10), 24L, new ListDTO("M", "new", "week", "new", "0")).stream().map(LikeVO::toString).forEach(log::info);
//    }

    // 좋아요 작품 목록 - 성공
//    @Test
//    public void getWorkListTest(){
//        likeDAO.getLikeWorkList(new Criteria(1, 10), 24L);
//    }

    // 좋아요한 아티스트 수
    @Test
    public void getTotalArtistTest(){
        likeDAO.getTotalArtist(24L, new ListDTO());
    }

    @Test
    public void getTotalWorkTest(){
        likeDAO.getTotalWork(24L);
    }
}
