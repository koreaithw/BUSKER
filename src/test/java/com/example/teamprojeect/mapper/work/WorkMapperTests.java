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
//    @Test //잘됨
//    public void insertApplyTest() {
//        WorkVO workVO = new WorkVO();
//        workVO.setArtistNumber(3L);
//        workVO.setWorkDescription("testDescription1");
//        workVO.setWorkGenre("힙합/랩");
//        workVO.setWorkName("testWork1");
//        workVO.setWorkPurchaseUrl("testurl1");
//        workVO.setWorkReleaseDate("2022-06-17");
//        workVO.setWorkYoutubeUrl("testYoutubeUrl1");
//        workVO.setWorkTag("힙합/랩");
//        workMapper.insertApply(workVO);
//    }

    // 작품 수정 신청
    @Test //잘됨
    public void updateWorkApplyTest() {
        WorkVO workVO = new WorkVO();
        workVO.setWorkName("updatetest1");
        workVO.setWorkDescription("updatedesc1");
        workVO.setWorkYoutubeUrl("updateurl1");
        workVO.setWorkPurchaseUrl("updatePurl1");
        workVO.setWorkNumber(1L);
        workMapper.updateApply(workVO);
    }

    // 작품 등록 신청 승인
//    @Test // 잘됨
//    public void insertAdminTest() {
//        Long workNumber = 2L;
//        workMapper.insertAdmin(workNumber);
//    }

    // 작품 수정 신청 승인
//    @Test //잘됨
//    public void updateAdminTest() {
//        Long workNumber = 1L;
//        workMapper.updateAdmin(workNumber);
//    }

    // 작품 삭제
//    @Test
//    public void deleteTest() {
//        Long workNumber = 2L;
//        workMapper.delete(workNumber);
//    }

}
