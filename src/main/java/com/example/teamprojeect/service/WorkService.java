package com.example.teamprojeect.service;

import com.example.teamprojeect.domain.dao.work.WorkDAO;
import com.example.teamprojeect.domain.dao.work.WorkFileDAO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.work.WorkVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkService {
    private final WorkDAO workDAO;
    private final WorkFileDAO workFileDAO;

    // 작품 등록 신청
    public void registerApply(WorkVO workVO){
        workDAO.registerApply(workVO);
    }

    // 작품 등록 신청 승인
    public void registerAdmin(Long workNumber) {
        workDAO.registerAdmin(workNumber);
    }

    // 작품 등록 신청 반려
    public void remove(Long workNumber) {
        workDAO.remove(workNumber);
    }

    // 작품 수정 신청
    public void modifyApply(WorkVO workVO){
        workDAO.modifyApply(workVO);
    }

    // 작품 수정 신청 승인
    public void modifyAdmin(Long workNumber) {
        workDAO.modifyAdmin(workNumber);
    }

    // 작품신청 상세 페이지
    public WorkVO getDetail(Long workNumber) {
        return workDAO.getDetail(workNumber);
    }

    // 작품 신청 전체 목록
    public List<WorkVO> getList(Criteria criteria) {
        return workDAO.getList(criteria);
    }

    // 작품 신청 개수
    public int getTotalApply() {
        return workDAO.getTotalApply();
    }
}
