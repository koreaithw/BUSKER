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

        showReplyVO.setShowNumber(472L);
        showReplyVO.setUserNumber(21L);
        showReplyVO.setReplyContent("이승윤 공연 진짜 개재밌음 추천행1");

        showReplyMapper.insert(showReplyVO);
        log.info("shpw 댓글 ++  " + showReplyVO.getReplyNumber());
    }

    @Test
    public void updateTest(){
        ShowReplyVO showReplyVO = new ShowReplyVO();

        showReplyVO.setReplyNumber(522L);
        showReplyVO.setReplyContent("업데이트 된 댓글 : 이승윤 공연 진짜 개재밌음 추천행");

        showReplyMapper.update(showReplyVO);
        log.info("shpw update 댓글 ++  " + showReplyVO.getReplyNumber());
    }

    @Test
    public void deleteTest() {
        Long showReplyNumber = 522L;
        showReplyMapper.delete(showReplyNumber);
        log.info("DELETE : " + showReplyMapper.delete(showReplyNumber));
    }

    @Test
    public void getTotalTest() {
        Long showNumber =  1315L;
        showReplyMapper.getTotal(showNumber);
    }
    @Test
    public void getListTest() {
        showReplyMapper.getList(new Criteria(1, 10), 1315L)
                .stream().map(ShowReplyVO::toString).forEach(log::info);
    }

    @Test
    public void getUserShowReplyTest(){
        showReplyMapper.getUserShowReply(new Criteria(1,10), 24L);
    }

    @Test
    public void getTotalUserShowReplyTest(){
        Long userNumber = 24L;
        showReplyMapper.getTotalUserShowReply(userNumber);
    }
}