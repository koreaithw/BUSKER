package com.example.teamprojeect.mapper.show;

import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.show.ShowVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.w3c.dom.Text;

import javax.script.ScriptContext;

@SpringBootTest
@Slf4j
public class ShowMapperTests {
    @Autowired
    private ShowMapper showMapper;

    @Test
    public void insertTest(){
        ShowVO showVO = new ShowVO();

        showVO.setArtistNumber(3L);
        showVO.setShowName("페퍼톤스");
        showVO.setShowContent("이승윤 무대 초대 컴컴");
        showVO.setShowDay("2022-06-06");
        showVO.setShowTime("22:24");
        showVO.setShowAddress("충북 청주시 흥덕구 1순환로 384");
        showVO.setShowLocation("푸른길 공원 앞");
        showVO.setShowType(1L);

        showMapper.insert(showVO);

        log.info("공연 번호 :" +  showVO.getShowNumber());
    }

    @Test
    public void updateTest(){
        ShowVO showVO = new ShowVO();

        showVO.setShowNumber(1315L);
        showVO.setArtistNumber(54L);
        showVO.setShowName("슈가볼로 업데이트");
        showVO.setShowContent("슈가볼 무대 초대 컴컴");
        showVO.setShowDay("2022/06/30");
        showVO.setShowTime("22:24");
        showVO.setShowAddress("충북 청주시 흥덕구 1순환로 384");
        showVO.setShowLocation("보라매 공원 앞");
        showVO.setShowType(2L);

        showMapper.update(showVO);

        log.info("공연 번호 :" +  showVO.getShowNumber());
    }

    @Test
    public void deleteTest(){
        Long showNumber = 216L;
        log.info("DELETE COUNT : " + showMapper.delete(showNumber));
    }

    @Test
    public void getDetailTest() {
        Long showNumber = 1315L;
        log.info("DELETE COUNT : " + showMapper.detail(showNumber));
        log.info(showMapper.detail(showNumber).toString());
    }

    @Test
    public void getListTest() {
        showMapper.getList(new Criteria(1, 10), new ListDTO("", "new", "week", "new", "1")).stream().map(ShowVO::toString).forEach(log::info);
    }

    @Test
    public void getListIngTest() {
        showMapper.getListIng(new ListDTO("M", "new", "week", "new", "0")).stream().map(ShowVO::toString).forEach(log::info);
    }

    @Test
    public void getTotalTest() {
        log.info(" 진행 예정 공연 개수 : " +  showMapper.getTotal(new ListDTO("M", "new", "week", "new", "6")));
    }

    @Test
    public void getTotalIngTest() {
        log.info("진행 중 공연 개수 : " +  showMapper.getTotalIng(new ListDTO("M", "new", "week", "new", "6")));
    }

    @Test
    public void getRankingReplyTest() {
        showMapper.getRankingReply().stream().map(ShowVO::toString).forEach(log::info);
    }
}
