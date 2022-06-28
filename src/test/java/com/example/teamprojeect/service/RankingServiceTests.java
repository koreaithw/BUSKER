package com.example.teamprojeect.service;
import com.example.teamprojeect.domain.vo.artist.ArtistDTO;
import com.example.teamprojeect.domain.vo.artist.ArtistVO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RankingServiceTests {
    @Autowired
    private RankingService rankingService;

    @Test
    public void rankingListTest(){
        rankingService.rankingListAll(new Criteria(1, 10), new ListDTO("A","B","C","LIKE","1"))
                .stream().map(ArtistDTO::toString).forEach(log::info);
    }

    @Test
    public void rankingListMusicianTest(){
        rankingService.rankingListMusician(new Criteria(1, 10), new ListDTO("A","B","C","LIKE","1"))
                .stream().map(ArtistDTO::toString).forEach(log::info);
    }

//    @Test
//    public void rankingListMusicianTest(){
//        rankingService.rankingListMusician(new Criteria(1, 10), new ListDTO("A","B","C","LIKE","1"))
//        rankingService.rankingList(new Criteria(1, 7), new ListDTO("A","B","C","LIKE","1"))
//                .stream().map(ArtistDTO::toString).forEach(log::info);
//    }

}

