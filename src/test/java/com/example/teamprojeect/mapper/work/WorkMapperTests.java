package com.example.teamprojeect.mapper.work;

import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.work.WorkVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@Slf4j
public class WorkMapperTests {
    @Autowired
    private WorkMapper workMapper;

//    @Test
//    public void workMapperTest() {
//        log.info(workMapper+"");
//    }

//     작품 등록 신청
//    @Test //잘됨
//    public void insertApplyTest() {
//        for (int i = 0; i < 15; i++){
//            WorkVO workVO = new WorkVO();
//            workVO.setArtistNumber(3L);
//            workVO.setWorkDescription("testDescription" + i);
//            workVO.setWorkGenre("힙합/랩");
//            workVO.setWorkName("testWork" + i);
//            workVO.setWorkPurchaseUrl("testurl" + i);
//            workVO.setWorkReleaseDate("2022-06-" + (i + 1));
//            workVO.setWorkYoutubeUrl("testYoutubeUrl" + i);
//            workVO.setWorkTag("힙합/랩");
//            workMapper.insertApply(workVO);
//        }
//    }

    // 작품 수정 신청
//    @Test //잘됨
//    public void updateWorkApplyTest() {
//        WorkVO workVO = new WorkVO();
//        workVO.setWorkName("updatetest1");
//        workVO.setWorkDescription("updatedesc1");
//        workVO.setWorkYoutubeUrl("updateurl1");
//        workVO.setWorkPurchaseUrl("updatePurl1");
//        workVO.setWorkNumber(1L);
//        workMapper.updateApply(workVO);
//    }

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

    // 작품신청 상세보기
//    @Test // 잘됨
//    public void getDetailTest() {
//        Long workNumber = 1L;
//        log.info(workMapper.getDetail(workNumber).toString());
//    }

    // 작품 신청 전체 목록
//    @Test
//    public void getListTest() {
//        workMapper.getList(new Criteria(1,10)).stream().map(WorkVO::toString).forEach(log::info);
//    }

    @Test
    public void getKeywordTest() {
        ListDTO listDTO = new ListDTO();
        List<String> tag = new ArrayList<>();
        tag.add("힙합/랩");
        listDTO.setTag(tag);
        workMapper.getKeyword(new Criteria(1,10),listDTO).stream().map(WorkVO::toString).forEach(log::info);
    }

//    @Test
//    public void getTagTest() {
//        workMapper.getTag();
//    }


        @Test // 잘됨
    public void insertAdminTest() {
        for(int i = 0; i < 15; i++){
          Long workNumber = 1L+i;
          workMapper.insertAdmin(workNumber);
        }
    }
}