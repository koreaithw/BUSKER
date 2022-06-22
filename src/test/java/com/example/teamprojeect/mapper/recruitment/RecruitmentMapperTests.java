package com.example.teamprojeect.mapper.recruitment;

import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.recruitment.RecruitmentVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RecruitmentMapperTests {
    @Autowired
    private RecruitmentMapper recruitmentMapper;

    @Test
    public void insertTest() {
        for(int i = 0; i < 130; i++){
            RecruitmentVO recruitmentVO = new RecruitmentVO();
            recruitmentVO.setRecruitmentName("테스트" + i);
            recruitmentVO.setRecruitmentLocation("예술의 전당");
            recruitmentVO.setRecruitmentDay("2022-07-09");
            recruitmentVO.setRecruitmentTime("오후 05:39");
            recruitmentVO.setRecruitmentType("P");
            recruitmentVO.setRecruitmentUrl("https://www.youtube.com/");
            recruitmentVO.setRecruitmentSummary("몇몇 일에 어디에서 개최");
            recruitmentVO.setRecruitmentCondition("초대합니다 어쩌구");
            recruitmentVO.setRecruitmentIntroduce("모두가 같이 즐기는");
            recruitmentVO.setRecruitmentHost("정부 개최");
            recruitmentMapper.insert(recruitmentVO);
            log.info("게시글 번호 :: "+recruitmentVO.getRecruitmentNumber());
        }
    }

    @Test
    public void getListTest() {
        Criteria criteria = new Criteria(1,10,null,null);
        recruitmentMapper.getList(criteria, new ListDTO("A","new", "week", "new", "1")).stream().map(RecruitmentVO::toString).forEach(log::info);
    }

//    @Test
//    public void updateTest() {
//        Long recruitmentNumber = 128L;
//        RecruitmentVO recruitmentVO = recruitmentMapper.getDetail(recruitmentNumber);
//        if(recruitmentVO == null) {log.info("NO FILE"); return;}
//        recruitmentVO.setRecruitmentName("아마추어 경연 페스티벌 수정");
//        recruitmentVO.setRecruitmentLocation("예술의 전당 수정");
//        recruitmentVO.setRecruitmentDay("2022-07-09");
//        recruitmentVO.setRecruitmentTime("오후 05:39");
//        recruitmentVO.setRecruitmentType("A");
//        recruitmentVO.setRecruitmentUrl("https://www.youtube.com/");
//        recruitmentVO.setRecruitmentSummary("몇몇 일에 어디에서 개최 수정");
//        recruitmentVO.setRecruitmentCondition("초대합니다 어쩌구 수정");
//        recruitmentVO.setRecruitmentIntroduce("모두가 같이 즐기는 수정");
//        recruitmentVO.setRecruitmentHost("정부 개최 수정");
//
//        log.info("update count : "+recruitmentMapper.update(recruitmentVO));
//    }

//    @Test
//    public void getTotalTest(){
//        log.info("총 개수 : "+recruitmentMapper.getTotal(new ListDTO("M","new", "week", "new", "1")));
//    }
}
