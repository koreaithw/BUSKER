package com.example.teamprojeect.mapper.show;

import com.example.teamprojeect.domain.vo.show.ShowFileVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ShowFileMapperTests {
    @Autowired
    private ShowFileMapper showFileMapper;

    @Test
    public void insertTest() {

        ShowFileVO showFileVO = new ShowFileVO();
        Long showNumber = 1315L;
        showFileVO.setShowNumber(showNumber);
        showFileVO.setUuid("파일테스트123");
        showFileVO.setUploadPath("123123");
        showFileVO.setFileName("파일 이름 테스트");

        showFileMapper.insert(showFileVO);
    }

    @Test
    public void deleteTest() {
        ShowFileVO showFileVO = new ShowFileVO();

        Long showNumber = 212L;

        showFileMapper.delete(showNumber);
    }

    @Test
    public void find() {
        Long showNumber = 212L;
        log.info(showFileMapper.find(showNumber).toString());
    }

}
