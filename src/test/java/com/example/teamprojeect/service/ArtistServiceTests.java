package com.example.teamprojeect.service;
import com.example.teamprojeect.domain.vo.artist.ArtistVO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ArtistServiceTests {
    @Autowired
    private ArtistService artistService;

    @Test
    public void registerApplyTest(){
        ArtistVO artistVO = new ArtistVO();
        artistVO.setUserNumber(10L);
        artistVO.setArtistName("김수연");
        artistVO.setArtistDescription("몰라");
        artistVO.setArtistType(2L);
        artistVO.setArtistAccount("김지연계좌");
        artistService.registerApply(artistVO);

        log.info("아티스트 번호" + artistVO.getArtistNumber());
    }

    @Test
    public void modifyApplyTest(){
        ArtistVO artistVO = new ArtistVO();

        artistVO.setArtistNumber(2L);
        artistVO.setArtistName("은솔");
        artistVO.setArtistDescription("안녕!");
        artistVO.setArtistType(1L);

        artistService.modifyApply(artistVO);
    }

    @Test
    public void removeTest(){
        Long artistNumber = 4L;
        log.info("IF DELETE" + artistService.removeArtist(artistNumber));
    }

    @Test
    public void getListTest(){
        artistService.getList(new Criteria(1,20), new ListDTO("A","B","C","NEW","1"))
                .stream().map(ArtistVO::toString).forEach(log::info);
    }

    @Test
    public void getListTestM(){
        artistService.getListMusician(new Criteria(1,20), new ListDTO("A","B","C","NEW","1"))
                .stream().map(ArtistVO::toString).forEach(log::info);
    }

    @Test
    public void getListTestP(){
        artistService.getListPerformance(new Criteria(1,20), new ListDTO("A","B","C","NEW","1"))
                .stream().map(ArtistVO::toString).forEach(log::info);
    }
}
