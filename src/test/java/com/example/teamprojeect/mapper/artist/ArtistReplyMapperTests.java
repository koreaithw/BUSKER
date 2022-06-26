package com.example.teamprojeect.mapper.artist;

import com.example.teamprojeect.domain.vo.paging.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ArtistReplyMapperTests {
    @Autowired
    private ArtistReplyMapper artistReplyMapper;

    // 유저가 아티스트에게 남긴 댓글
    @Test
    public void getUserReplyTest(){
        artistReplyMapper.getUserReplyList(new Criteria(1,10), 24L);
    }

    // 유저가 아티스트에게 남긴 댓글 갯수
    @Test
    public void getUserTotalReply(){
        Long userNumber = 24L;
        artistReplyMapper.getTotalUserReply(userNumber);
    }
}
