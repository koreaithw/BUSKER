package com.example.teamprojeect.domain.dao.work;

import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.work.WorkFileVO;
import com.example.teamprojeect.domain.vo.work.WorkVO;
import com.example.teamprojeect.mapper.work.WorkFileMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class WorkFileDAO {
    private final WorkFileMapper workFileMapper;

    // 작품 사진 추가
    public void register(WorkFileVO workFileVO) {
        workFileMapper.insert(workFileVO);
    }

    // 작품 사진 삭제
    public void remove(Long workNumber) {
        workFileMapper.delete(workNumber);
    }

    // 작품 사진 선택
    public WorkFileVO find(Long workNumber) {
        return workFileMapper.find(workNumber);
    }
}
