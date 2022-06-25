package com.example.teamprojeect.domain.dao.show;

import com.example.teamprojeect.domain.vo.show.ShowFileVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ShowFileDaoTests {
    @Autowired
    private ShowFileDAO showFileDAO;

    @Test
    public void registerTest() {

        ShowFileVO showFileVO = new ShowFileVO();
        Long showNumber = 530L;
        showFileVO.setShowNumber(showNumber);
        showFileVO.setUuid("파일테스트123");
        showFileVO.setUploadPath("123123");
        showFileVO.setFileName("파일 이름 테스트");

        showFileDAO.register(showFileVO);
    }

    @Test
    public void removeTest() {
        ShowFileVO showFileVO = new ShowFileVO();

        Long showNumber = 530L;

        showFileDAO.remove(showNumber);
    }

    @Test
    public void find() {
        Long showNumber = 530L;
        log.info(showFileDAO.find(showNumber).toString());
    }
}
