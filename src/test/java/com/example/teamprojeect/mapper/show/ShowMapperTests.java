package com.example.teamprojeect.mapper.show;

import com.example.teamprojeect.domain.vo.show.ShowVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ShowMapperTests {
    @Autowired
    private ShowMapper showMapper;

    @Test
    public void insertTest(){
        ShowVO showVO = new ShowVO();

        showVO.setArtistNumber(54L);
        showVO.setShowName("페퍼톤스");
        showVO.setShowContent("이승윤 무대 초대 컴컴");
        showVO.setShowDay("2022-06-06");
        showVO.setShowTime("오후 03:24");
        showVO.setShowAddress("충북 청주시 흥덕구 1순환로 384");
        showVO.setShowLocation("푸른길 공원 앞");
        showVO.setShowType(1L);

        showMapper.insert(showVO);

        log.info("공연 번호 :" +  showVO.getShowNumber());
        log.info("공연 번호 :" +  showVO.getShowNumber());
        log.info("공연 번호 :" +  showVO.getShowNumber());
        log.info("공연 번호 :" +  showVO.getShowNumber());
        log.info("공연 번호 :" +  showVO.getShowNumber());
        log.info("공연 번호 :" +  showVO.getShowNumber());
    }

    @Test
    public void updateTest(){
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

        showMapper.update(showVO);

        log.info("공연 번호 :" +  showVO.getShowNumber());
        log.info("공연 번호 :" +  showVO.getShowNumber());
        log.info("공연 번호 :" +  showVO.getShowNumber());
        log.info("공연 번호 :" +  showVO.getShowNumber());
        log.info("공연 번호 :" +  showVO.getShowNumber());
        log.info("공연 번호 :" +  showVO.getShowNumber());
    }

    @Test
    public void deleteTest(){
        Long showNumber = 216L;
        log.info("DELETE COUNT : " + showMapper.delete(showNumber));
    }

    @Test
    public void getDetailTest() {
        Long showNumber = 217L;
        log.info("DELETE COUNT : " + showMapper.detail(showNumber));
        log.info(showMapper.detail(showNumber).toString());
    }
}
