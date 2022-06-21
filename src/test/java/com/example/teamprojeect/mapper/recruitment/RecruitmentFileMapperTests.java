package com.example.teamprojeect.mapper.recruitment;

import com.example.teamprojeect.domain.vo.recruitment.RecruitmentFileVO;
import com.example.teamprojeect.domain.vo.recruitment.RecruitmentVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RecruitmentFileMapperTests {
    @Autowired
    private RecruitmentFileMapper recruitmentFileMapper;

//    @Test
//    public void insertTest() {
//        RecruitmentFileVO recruitmentFileVO = new RecruitmentFileVO();
//        Long RecruitmentNumber = 97L;
//        recruitmentFileVO.setFileName("FILE");
//        recruitmentFileVO.setUploadPath("test");
//        recruitmentFileVO.setRecruitmentNumber(RecruitmentNumber);
//        recruitmentFileVO.setUuid("rmfaks");
//        recruitmentFileMapper.insert(recruitmentFileVO);
//    }

//    @Test
//    public void deleteTest() {
//        Long recruitmentNumber = 128L;
//        recruitmentFileMapper.delete(recruitmentNumber);
//    }

//    @Test
//    public void findTest() {
//        Long recruitmentNumber = 97L;
//        log.info(recruitmentFileMapper.find(recruitmentNumber).toString());
//    }

}
