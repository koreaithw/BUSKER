package com.example.teamprojeect.mapper.work;

import com.example.teamprojeect.domain.vo.work.WorkVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
public class WorkMapperTests {
    @Autowired
    private WorkMapper workMapper;

//    @Test
//    public void workMapperTest() {
//        log.info(workMapper+"");
//    }

    // 작품 등록 신청
//    @Test
//    public void insertApplyTest() {
//        WorkVO workVO = new WorkVO();
//        workVO.setArtistNumber(3L);
//        workVO.setWorkDescription("testDescription");
//        workVO.setWorkGenre("발라드");
//        workVO.setWorkName("testWork");
//        workVO.setWorkPurchaseUrl("testurl");
//        workVO.setWorkReleaseDate("2022-06-16");
//        workVO.setWorkYoutubeUrl("testYoutubeUrl");
//        workVO.setWorkTag("발라드");
//        workMapper.insertApply(workVO, 3L);
//    }

    // 작품 수정 신청
    @Test
    public void updateApplyTest() {
        WorkVO workVO = new WorkVO();
        workVO.setWorkName("updatetest");
        workVO.setWorkDescription("updatedesc");
        workVO.setWorkYoutubeUrl("updateurl");
        workVO.setWorkPurchaseUrl("updatePurl");
        workVO.setArtistNumber(3L);
        workMapper.updateApply(workVO, 3L);
    }


}
