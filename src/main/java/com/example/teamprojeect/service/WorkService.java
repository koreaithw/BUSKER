package com.example.teamprojeect.service;

import com.example.teamprojeect.domain.dao.work.WorkDAO;
import com.example.teamprojeect.domain.dao.work.WorkFileDAO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.show.ShowFileVO;
import com.example.teamprojeect.domain.vo.work.WorkFileVO;
import com.example.teamprojeect.domain.vo.work.WorkVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class WorkService {
    private final WorkDAO workDAO;
    private final WorkFileDAO workFileDAO;

    // 작품 등록 신청
    @Transactional(rollbackFor = Exception.class)
    public void registerApply(WorkVO workVO){
        log.info("test : "+workVO);
        WorkFileVO workFileVO = workVO.getFile();
        workDAO.registerApply(workVO);
        workFileVO.setWorkNumber(workVO.getWorkNumber());
        workFileDAO.register(workFileVO);
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
    @Transactional(rollbackFor = Exception.class)
    public boolean modifyApply(WorkVO workVO){
        workFileDAO.remove(workVO.getWorkNumber());
        WorkFileVO workFileVO = workVO.getFile();
        workFileVO.setWorkNumber(workVO.getWorkNumber());
        workFileDAO.register(workFileVO);
        return workDAO.modifyApply(workVO);
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

    // 작품 태그 검색  (태그를 선택할때마다 리스트에 추가하고, 쿼리문에서 리스트 하나씩뽑아서 if문 돌리기)
    public List<WorkVO> getKeyword(Criteria criteria, ListDTO listDTO) {return workDAO.getKeyword(criteria,listDTO);}

    // 작품 태그
    public List<String> getTag() { return workDAO.getTag();}

    // 작품 신청 개수
    public int getTotalApply() {
        return workDAO.getTotalApply();
    }

    public int getArtist(Long workNumber) {
        return workDAO.getArtist(workNumber);
    }

    public int getTotalListApply() {
        return workDAO.getTotalListApply();
    }

    public void removeFile(Long workNumber) {workFileDAO.remove(workNumber);}

    public WorkFileVO find(Long workNumber) { return workFileDAO.find(workNumber);}

}
