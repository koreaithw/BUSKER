package com.example.teamprojeect.mapper.artist;

import com.example.teamprojeect.domain.vo.artist.ArtistVO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ArtistMapperTests {

    @Autowired
    private ArtistMapper artistMapper;

    //최신순 정렬 테스트
//    @Test
//    public void getListTest(){
//        artistMapper.getList(new ListDTO("A","1","2","new","3"))
//
//                .stream().map(ArtistVO::toString).forEach(log::info);
//    }

    @Test
    public void getListTest(){
        artistMapper.getList(new ListDTO("A","1","2","NEW","3"))

                .stream().map(ArtistVO::toString).forEach(log::info);
    }

    @Test
    public void getListMusicianTest(){
        artistMapper.getListMusician(new ListDTO("A","1","2","NEW","3"))

                .stream().map(ArtistVO::toString).forEach(log::info);
    }

    @Test
    public void getListPerformanceTest(){
        artistMapper.getListPerformance(new ListDTO("A","1","2","NEW","3"))

                .stream().map(ArtistVO::toString).forEach(log::info);
    }
}