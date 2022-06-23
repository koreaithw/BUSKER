package com.example.teamprojeect.mapper.work;

import com.example.teamprojeect.domain.vo.work.WorkFileVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class WorkFileMapperTests {
    @Autowired
    private WorkFileMapper workFileMapper;

//    @Test
//    public void insertTest() {
//        for(int i = 15; i < 19 ; i++) {
//            WorkFileVO workFileVO = new WorkFileVO();
//            workFileVO.setFileName("가나다라"+i);
//            workFileVO.setUploadPath("마바사"+i);
//            workFileVO.setUuid("aidifai"+i);
//            workFileVO.setWorkNumber(7L);
//            workFileMapper.insert(workFileVO);
//        }
//
//    }
//
//    @Test
//    public void deleteTest() {
//        workFileMapper.delete("aidifai");
//    }

    @Test
    public void findTest() {
        workFileMapper.find(8L);
    }
}
