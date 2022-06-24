package com.example.teamprojeect.service;

import com.example.teamprojeect.domain.dao.recruitment.RecruitmentDAO;
import com.example.teamprojeect.domain.dao.recruitment.RecruitmentFileDAO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.recruitment.RecruitmentFileVO;
import com.example.teamprojeect.domain.vo.recruitment.RecruitmentVO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecruitService {
    private final RecruitmentDAO recruitmentDAO;
    private final RecruitmentFileDAO recruitmentFileDAO;

    public void register(RecruitmentVO recruitmentVO, RecruitmentFileVO recruitmentFileVO){
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

    public List<RecruitmentFileVO> getFiles(Long recruitmentNumber) {
        return recruitmentFileDAO.find(recruitmentNumber);
    }
}
