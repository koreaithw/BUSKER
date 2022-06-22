package com.example.teamprojeect.service;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
public class WorkServiceTests {
    @Autowired
    private WorkService workService;

    // 작품 등록 신청
//    @Test // 잘됨
//    public void insertApplyTest() {
//        WorkVO workVO = new WorkVO();
//        workVO.setArtistNumber(3L);
//        workVO.setWorkDescription("testDescription2");
//        workVO.setWorkGenre("발라드2");
//        workVO.setWorkName("testWork2");
//        workVO.setWorkPurchaseUrl("testurl2");
//        workVO.setWorkReleaseDate("2022-06-17");
//        workVO.setWorkYoutubeUrl("testYoutubeUrl2");
//        workVO.setWorkTag("발라드2");
//        workService.registerApply(workVO);
//    }

    // 작품 수정 신청
//    @Test // 잘됨
//    public void updateApplyTest() {
//        WorkVO workVO = new WorkVO();
//        workVO.setWorkName("updatetest2");
//        workVO.setWorkDescription("updatedesc2");
//        workVO.setWorkYoutubeUrl("updateurl2");
//        workVO.setWorkPurchaseUrl("updatePurl2");
//        workVO.setWorkNumber(2L);
//        workService.modifyApply(workVO);
//    }

    // 작품 수정 신청 승인
//    @Test // 잘됨
//    public void updateAdminTest() {
//        Long workNumber = 2L;
//        workService.modifyAdmin(workNumber);
//    }

    // 작품 등록 신청 승인
//    @Test // 잘됨
//    public void registerApplyTest() {
//        Long workNumber = 4L;
//        workService.registerAdmin(workNumber);
//    }

    // 작품 삭제
//    @Test // 잘됨
//    public void deleteTest() {
//        Long workNumber = 4L;
//        workService.remove(workNumber);
//    }

    // 작품 태그 검색
//    @Test
//    public void getKeywordTest() {
//        ListDTO listDTO = new ListDTO();
//        List<String> tag = new ArrayList<>();
//        tag.add("유튜브");
//        tag.add("힙합/랩");
//        listDTO.setTag(tag);
//        workService.getKeyword(new Criteria(1,10),listDTO).stream().map(WorkVO::toString).forEach(log::info);
//    }

    @Test
    public void getTagTest() {
        List<String> tag = workService.getTag();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < tag.size() ; i++){
            String str[] = tag.get(i).split("#");
            // 힙합/랩 , 유튜브, 영상 (15) / 노래, 유튜브, 영상, CD
            for(int j = 0; j <str.length; j++) {
                list.add(str[j]);
            }
        }
        List<String> list2 = list.stream().distinct().collect(Collectors.toList());
        log.info(list2.toString());
    }
}
