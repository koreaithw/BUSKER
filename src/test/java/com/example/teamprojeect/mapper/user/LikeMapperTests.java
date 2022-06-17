package com.example.teamprojeect.mapper.user;

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

    // 좋아요 등록 (아티스트) 테스트 에러 뜸 > 미완
    @Test
    public void insertArtistLike(){
        LikeVO likeVO = new LikeVO();

        likeVO.setUserNumber(1L);
        likeVO.setArtistNumber(1L);

        likeMapper.insertArtistLike(likeVO);
        log.info("아티스트 좋아요 등록 성공 + " + likeVO);
    }
}
