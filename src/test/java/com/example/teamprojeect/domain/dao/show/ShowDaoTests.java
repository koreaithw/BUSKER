package com.example.teamprojeect.domain.dao.show;

import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.show.ShowVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ShowDaoTests {
    @Autowired
    private ShowDAO showDAO;

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

        showDAO.register(showVO);

        log.info("공연 번호 :" +  showVO.getShowNumber());
    }

    @Test
    public void modifyTest() {
        ShowVO showVO = new ShowVO();

        showVO.setShowNumber(64L);
        showVO.setArtistNumber(54L);
        showVO.setShowName("슈가볼로 업데이트");
        showVO.setShowContent("슈가볼 무대 초대 컴컴");
        showVO.setShowDay("2022-06-31");
        showVO.setShowTime("오후 09:24");
        showVO.setShowAddress("충북 청주시 흥덕구 1순환로 384");
        showVO.setShowLocation("보라매 공원 앞");
        showVO.setShowType(2L);

        showDAO.modify(showVO);

        log.info("공연 번호 :" +  showVO.getShowNumber());
    }

    @Test
    public void removeTest() {
        Long showNumber = 481L;
        log.info("DELETE COUNT : " + showDAO.remove(showNumber));
    }

    @Test
    public void getListTest() {
        showDAO.getList(new Criteria(3, 5), new ListDTO("M", "new", "week", "new", "1")).stream().map(ShowVO::toString).forEach(log::info);
    }

    @Test
    public void getListIngTest() {
        showDAO.getListIng(new ListDTO("M", "new", "week", "new", "6")).stream().map(ShowVO::toString).forEach(log::info);
    }

    @Test
    public void getTotalTest() {
        log.info(" 진행 예정 공연 개수 : " +  showDAO.getTotal(new ListDTO("M", "new", "week", "new", "6")));
    }

    @Test
    public void getTotalIngTest() {
        log.info("진행 중 공연 개수 : " +  showDAO.getTotalIng(new ListDTO("M", "new", "week", "new", "6")));
    }

    @Test
    public void readTest() {
        Long showNumber = 1315L;
        log.info("DELETE COUNT : " + showDAO.read(showNumber));
        log.info(showDAO.read(showNumber).toString());
    }

}
