package com.example.teamprojeect.domain.dao.artist;

import com.example.teamprojeect.domain.vo.artist.ArtistVO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ArtistDaoTests {
    @Autowired
    private ArtistDAO artistDAO;
    private ListDTO listDTO;

    @Test
    public void getListTest(){
        artistDAO.getList(new Criteria(1,5), new ListDTO("A","B","C","LIKE","1"))
                .stream().map(ArtistVO::toString).forEach(log::info);
    }
}
