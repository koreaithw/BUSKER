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
    public void getListTest(){
        artistService.getList(new Criteria(1,20), new ListDTO("A","B","C","NEW","1"))
                .stream().map(ArtistVO::toString).forEach(log::info);
    }
}
