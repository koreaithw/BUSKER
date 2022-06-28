package com.example.teamprojeect.domain.dao.work;
import com.example.teamprojeect.domain.vo.work.WorkFileVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class WorkFileDaoTests {
    @Autowired
    private WorkFileDAO workFileDAO;

//    @Test
//    public void registerTest() {
//        for(int i = 19; i < 5 ; i++) {
//            WorkFileVO workFileVO = new WorkFileVO();
//            workFileVO.setFileName("가나다라"+i);
//            workFileVO.setUploadPath("마바사"+i);
//            workFileVO.setUuid("aidifai"+i);
//            workFileVO.setWorkNumber(7L);
//            workFileDAO.register(workFileVO);
//        }
//
//    }
//
//    @Test
//    public void removeTest() {
//        workFileDAO.remove("aidifai");
//    }

    @Test
    public void findTest() {
        workFileDAO.find(8L);
    }
}
