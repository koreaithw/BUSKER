package com.example.teamprojeect.domain.dao.recruitment;

import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.recruitment.RecruitmentFileVO;
import com.example.teamprojeect.domain.vo.recruitment.RecruitmentVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RecruimentFileDaoTests {
    @Autowired
    private RecruitmentFileDAO recruitmentFileDAO;

//    @Test
//    public void registerTest() {
//        RecruitmentFileVO recruitmentFileVO = new RecruitmentFileVO();
//        Long RecruitmentNumber = 96L;
//        recruitmentFileVO.setFileName("FILE");
//        recruitmentFileVO.setUploadPath("test");
//        recruitmentFileVO.setRecruitmentNumber(RecruitmentNumber);
//        recruitmentFileVO.setUuid("rmasfaks");
//        recruitmentFileDAO.register(recruitmentFileVO);
//    }

//    @Test
//    public void removeTest() {
//        Long recruitmentNumber = 97L;
//        recruitmentFileDAO.remove(recruitmentNumber);
//    }

    @Test
    public void findTest() {
        Long recruitmentNumber = 98L;
        log.info(recruitmentFileDAO.find(recruitmentNumber).toString());
    }

}
