package com.example.teamprojeect.domain.dao.show;

import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.show.ShowReplyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ShowReplyDaoTests {
    @Autowired
    private ShowReplyDAO showReplyDAO;


    @Test
    public void registerTest() {
        ShowReplyVO showReplyVO = new ShowReplyVO();

        showReplyVO.setShowNumber(1315L);
        showReplyVO.setUserNumber(21L);
        showReplyVO.setReplyContent("이승윤 공연 진짜 개재밌음 추천행1");

        showReplyDAO.register(showReplyVO);
        log.info("show 댓글 ++  " + showReplyVO.getReplyNumber());
    }

    @Test
    public void modifyTest(){
        ShowReplyVO showReplyVO = new ShowReplyVO();

        showReplyVO.setReplyNumber(66128L);
        showReplyVO.setReplyContent("업데이트 된 댓글 : 이승윤 공연 진짜 개재밌음 추천행");

        showReplyDAO.modify(showReplyVO);
        log.info("shpw update 댓글 ++  " + showReplyVO.getReplyNumber());
    }

    @Test
    public void removeTest() {
        Long showReplyNumber = 66128L;
        showReplyDAO.remove(showReplyNumber);
        log.info("DELETE : " + showReplyDAO.remove(showReplyNumber));
    }

    @Test
    public void getListTest() {
        showReplyDAO.getList(new Criteria(1, 10), 1315L)
                .stream().map(ShowReplyVO::toString).forEach(log::info);
    }

    @Test
    public void getTotalTest() {
        Long showNumber =  1315L;
        showReplyDAO.getTotal(showNumber);
    }
}
