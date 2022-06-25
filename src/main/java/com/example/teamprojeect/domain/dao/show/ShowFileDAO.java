package com.example.teamprojeect.domain.dao.show;

import com.example.teamprojeect.domain.vo.show.ShowFileVO;
import com.example.teamprojeect.mapper.show.ShowFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ShowFileDAO {
    private final ShowFileMapper showFileMapper;

    // 공연 사진 추가
    public void register(ShowFileVO showFileVO) {
        showFileMapper.insert(showFileVO);
    }

    // 공연 사진 삭제
    public void remove(Long showNumber) {
        showFileMapper.delete(showNumber);
    }

//    // 공연 사진 변경
//    public void modify(ShowFileVO showFileVO) {
//        showFileMapper.update(showFileVO);
//    }

    // 공연 사진 선택
    public ShowFileVO find(Long showNumber) {
        return showFileMapper.find(showNumber);
    }
//    public List<ShowFileVO> find(Long showNumber) {
//        return showFileMapper.find(showNumber);
//    }
}
