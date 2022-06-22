package com.example.teamprojeect.service;

import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.show.ShowFileVO;
import com.example.teamprojeect.domain.vo.show.ShowReplyVO;
import com.example.teamprojeect.domain.vo.show.ShowVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ShowServiceTests {
    @Autowired
    private ShowService showService;

    @Test
    public void registerTest() {
        ShowVO showVO = new ShowVO();

        showVO.setArtistNumber(54L);
        showVO.setShowName("페퍼톤스");
        showVO.setShowContent("이승윤 무대 초대 컴컴");
        showVO.setShowDay("2022-06-06");
        showVO.setShowTime("오후 03:24");
        showVO.setShowAddress("충북 청주시 흥덕구 1순환로 384");
        showVO.setShowLocation("푸른길 공원 앞");
        showVO.setShowType(1L);

        ShowFileVO showFileVO = new ShowFileVO();
        Long showNumber = showVO.getShowNumber();
        showFileVO.setShowNumber(showNumber);
        showFileVO.setUuid("파일테스트12345454542");
        showFileVO.setUploadPath("123123");
        showFileVO.setFileName("파일 이름 테스트");

        showService.register(showVO);

        log.info("공연 번호 :" +  showVO.getShowNumber());
    }

    @Test
    public void modifyTest() {
        ShowVO showVO = new ShowVO();

        showVO.setShowNumber(1315L);
        showVO.setArtistNumber(54L);
        showVO.setShowName("슈가볼로 업데이트");
        showVO.setShowContent("슈가볼 무대 초대 컴컴");
        showVO.setShowDay("2022-06-30");
        showVO.setShowTime("오후 09:24");
        showVO.setShowAddress("충북 청주시 흥덕구 1순환로 384");
        showVO.setShowLocation("보라매 공원 앞");
        showVO.setShowType(2L);

        showService.modify(showVO);

        log.info("공연 번호 :" +  showVO.getShowNumber());
    }

    @Test
    public void removeTest() {
        Long showNumber = 1316L;
        log.info("DELETE COUNT : " + showService.remove(showNumber));
    }

    @Test
    public void getListTest() {
        showService.getList(new Criteria(1, 5), new ListDTO("M", "new", "week", "new", "1")).stream().map(ShowVO::toString).forEach(log::info);
    }

    @Test
    public void getListIngTest() {
        showService.getListIng(new ListDTO("M", "new", "week", "new", "6")).stream().map(ShowVO::toString).forEach(log::info);
    }

    @Test
    public void getTotalTest() {
        log.info(" 진행 예정 공연 개수 : " +  showService.getTotal(new ListDTO("M", "new", "week", "new", "6")));
    }

    @Test
    public void getTotalIngTest() {
        log.info("진행 중 공연 개수 : " +  showService.getTotalIng(new ListDTO("M", "new", "week", "new", "6")));
    }

    @Test
    public void readTest() {
        Long showNumber = 1315L;
        log.info("DELETE COUNT : " + showService.read(showNumber));
        log.info(showService.read(showNumber).toString());
    }


    @Test
    public void registerReplyTest() {
        ShowReplyVO showReplyVO = new ShowReplyVO();

        showReplyVO.setShowNumber(1315L);
        showReplyVO.setUserNumber(21L);
        showReplyVO.setReplyContent("이승윤 공연 진짜 개재밌음 추천행1");

        showService.registerReply(showReplyVO);
        log.info("show 댓글 ++  " + showReplyVO.getReplyNumber());
    }

    @Test
    public void modifyReplyTest(){
        ShowReplyVO showReplyVO = new ShowReplyVO();

        showReplyVO.setReplyNumber(66128L);
        showReplyVO.setReplyContent("업데이트 된 댓글 : 이승윤 공연 진짜 개재밌음 추천행");

        showService.modifyReply(showReplyVO);
        log.info("shpw update 댓글 ++  " + showReplyVO.getReplyNumber());
    }

    @Test
    public void removeReplyTest() {
        Long showReplyNumber = 66128L;
        showService.removeReply(showReplyNumber);
        log.info("DELETE : " + showService.remove(showReplyNumber));
    }

    @Test
    public void getListReplyTest() {
        showService.getListReply(new Criteria(1, 10), 1315L)
                .stream().map(ShowReplyVO::toString).forEach(log::info);
    }

    @Test
    public void getTotalReplyTest() {
        Long showNumber =  1315L;
        showService.getTotalReply(showNumber);
    }

}
