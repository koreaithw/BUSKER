package com.example.teamprojeect.service;

import com.example.teamprojeect.domain.dao.recruitment.RecruitmentDAO;
import com.example.teamprojeect.domain.dao.recruitment.RecruitmentFileDAO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.recruitment.RecruitmentFileVO;
import com.example.teamprojeect.domain.vo.recruitment.RecruitmentVO;
import com.example.teamprojeect.domain.vo.show.ShowFileVO;
import com.example.teamprojeect.domain.vo.show.ShowVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RecruitService {
    private final RecruitmentDAO recruitmentDAO;
    private final RecruitmentFileDAO recruitmentFileDAO;

    public void register(RecruitmentVO recruitmentVO){
        log.info("11" + recruitmentVO);
        RecruitmentFileVO recruitmentFileVO = recruitmentVO.getFile();
        recruitmentDAO.register(recruitmentVO);
        recruitmentFileVO.setRecruitmentNumber(recruitmentVO.getRecruitmentNumber());
        recruitmentFileDAO.register(recruitmentFileVO);
    }

    public boolean modify(RecruitmentVO recruitmentVO) {
        return recruitmentDAO.modify(recruitmentVO);
    }

    public boolean remove(Long recruitmentNumber) {
        return recruitmentDAO.remove(recruitmentNumber);
    }

    public List<RecruitmentVO> getList(@Param("criteria") Criteria criteria, @Param("listDTO") ListDTO listDTO) {
        return recruitmentDAO.getList(criteria, listDTO);
    }

    public int getTotal(ListDTO listDTO) {
        return recruitmentDAO.getTotal(listDTO);
    }

    public RecruitmentVO getDetail(Long recruitmentNumber) {
        return recruitmentDAO.getDetail(recruitmentNumber);
    }

    public RecruitmentFileVO getFiles(Long recruitmentNumber) {
        return recruitmentFileDAO.find(recruitmentNumber);
    }

    public void removeFile(Long showNumber) {recruitmentFileDAO.remove(showNumber);}

}
