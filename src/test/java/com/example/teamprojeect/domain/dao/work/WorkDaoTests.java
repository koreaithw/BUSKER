package com.example.teamprojeect.domain.dao.work;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.work.WorkVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
public class WorkDaoTests {
    @Autowired
    private WorkDAO workDAO;


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
//        workDAO.registerApply(workVO);
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
//        workDAO.modifyApply(workVO);
//    }

    // 작품 수정 신청 승인
//    @Test // 잘됨
//    public void updateAdminTest() {
//        Long workNumber = 2L;
//        workDAO.modifyAdmin(workNumber);
//    }

    // 작품 등록 신청 승인
//    @Test // 잘됨
//    public void registerApplyTest() {
//        Long workNumber = 4L;
//        workDAO.registerAdmin(workNumber);
//    }

    // 작품 삭제
//    @Test // 잘됨
//    public void deleteTest() {
//        Long workNumber = 4L;
//        workDAO.remove(workNumber);
//    }

    // 작품 태그 검색
//    @Test
//    public void getKeywordTest() {
//        ListDTO listDTO = new ListDTO();
//        List<String> tag = new ArrayList<>();
//        tag.add("유튜브");
//        tag.add("힙합/랩");
//        listDTO.setTag(tag);
//        workDAO.getKeyword(new Criteria(1,10),listDTO).stream().map(WorkVO::toString).forEach(log::info);
//    }

    @Test
    public void getTagTest() {
        List<String> tag = workDAO.getTag();
        List<String> arr = new ArrayList<String>();
        for (int i = 0; i < tag.size() ; i++){
            String str[] = tag.get(i).split("#");
            // 힙합/랩 , 유튜브, 영상 (15) / 노래, 유튜브, 영상, CD
            for(int j = 0; j <str.length; j++) {
                arr.add(str[j]);
            }
        }
        List<String> list = arr.stream().distinct().collect(Collectors.toList());
        log.info(list.toString());
    }
}
