package com.example.teamprojeect.domain.dao.recruitment;

import com.example.teamprojeect.domain.vo.recruitment.RecruitmentVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RecruitmentDaoTests {
    @Autowired
    private RecruitmentDAO recruitmentDAO;

    @Test
    public void insertTest() {
        for(int i = 0; i < 5; i++){
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
            recruitmentDAO.register(recruitmentVO);
            log.info("게시글 번호 :: "+recruitmentVO.getRecruitmentNumber());
        }
    }
}
