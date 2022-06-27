package com.example.teamprojeect.domain.dao.artist;

import com.example.teamprojeect.domain.vo.artist.ArtistDTO;
import com.example.teamprojeect.domain.vo.artist.ArtistVO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class ArtistDaoTests {
    @Autowired
    private ArtistDAO artistDAO;
    private ListDTO listDTO;

    @Test
    public void insertApplyTest(){
        ArtistVO artistVO = new ArtistVO();
        artistVO.setUserNumber(11L);
        artistVO.setArtistName("김지연");
        artistVO.setArtistDescription("몰라");
        artistVO.setArtistType(1L);
        artistVO.setArtistAccount("김지연계좌");
        artistDAO.registerApply(artistVO);

        log.info("아티스트 번호" + artistVO.getArtistNumber());
    }

    @Test
    public void modifyTest(){
        ArtistVO artistVO = new ArtistVO();

        artistVO.setArtistNumber(2L);
        artistVO.setArtistName("은솔");
        artistVO.setArtistDescription("안녕!");
        artistVO.setArtistType(1L);

        artistDAO.modifyApply(artistVO);
    }

    @Test
    public void removeTest(){
        log.info("DELETE COUNT : " + artistDAO.remove(4L));
    }

    @Test
    public void getListTest(){
        artistDAO.getList(new Criteria(1,5), new ListDTO("A","B","C","LIKE","1"))
                .stream().map(ArtistVO::toString).forEach(log::info);
    }

    @Test
    public void rankingListTest(){
        artistDAO.rankingListAll(new Criteria(1, 10), new ListDTO("A","B","C","LIKE","1"))
                .stream().map(ArtistDTO::toString).forEach(log::info);
    }

    @Test
    public void rankingListMusicianTest(){
        artistDAO.rankingListMusician(new Criteria(1, 10), new ListDTO("A","B","C","LIKE","1"))
                .stream().map(ArtistDTO::toString).forEach(log::info);
    }

//    @Test
//    public List<ArtistVO> getList(){
//        log.info(artistDAO.getList().toString());
//    }




//    @Test
//    public void getListTest(){
//        artistDAO.getList(new ListDTO("A", "new", "week", "new", "1"))
//                .stream().map(ArtistVO::toString).forEach(log::info);
//    }

//    @Test
//    public void rankingListTest(){
//        artistDAO.getList(new Criteria()).stream().map(ArtistVO::toString).forEach(log::info);
//    }

}


