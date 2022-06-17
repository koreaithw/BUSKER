package com.example.teamprojeect.mapper.show;

import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.show.ShowReplyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ShowReplyMapperTests {
    @Autowired
    private ShowReplyMapper showReplyMapper;

    @Test
    public void insertTest() {
        ShowReplyVO showReplyVO = new ShowReplyVO();

        showReplyVO.setShowNumber(218L);
        showReplyVO.setUserNumber(21L);
        showReplyVO.setReplyContent("이승윤 공연 진짜 개재밌음 추천행");

        showReplyMapper.insert(showReplyVO);
        log.info("shpw 댓글 ++  " + showReplyVO.getReplyNumber());
        log.info("shpw 댓글 ++  " + showReplyVO.getReplyNumber());
        log.info("shpw 댓글 ++  " + showReplyVO.getReplyNumber());
        log.info("shpw 댓글 ++  " + showReplyVO.getReplyNumber());
    }

    @Test
    public void updateTest(){
        ShowReplyVO showReplyVO = new ShowReplyVO();

        showReplyVO.setReplyNumber(1L);
        showReplyVO.setReplyContent("업데이트 된 댓글 : 이승윤 공연 진짜 개재밌음 추천행");

        showReplyMapper.update(showReplyVO);
        log.info("shpw update 댓글 ++  " + showReplyVO.getReplyNumber());
        log.info("shpw update 댓글 ++  " + showReplyVO.getReplyNumber());
        log.info("shpw update 댓글 ++  " + showReplyVO.getReplyNumber());
        log.info("shpw update 댓글 ++  " + showReplyVO.getReplyNumber());
    }

    @Test
    public void getListTest() {
        showReplyMapper.getList(new Criteria(1, 10), 218L)
                .stream().map(ShowReplyVO::toString).forEach(log::info);
    }

    @Test
    public void deleteTest() {
        Long showReplyNumber = 237L;
        showReplyMapper.delete(237L);
        log.info("DELETE : " + showReplyMapper.delete(showReplyNumber));
    }
}
