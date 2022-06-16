package com.example.teamprojeect.service;

import com.example.teamprojeect.domain.dao.recruitment.RecruitmentDAO;
import com.example.teamprojeect.domain.dao.recruitment.RecruitmentFileDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecruitService {
    private final RecruitmentDAO recruitmentDAO;
    private final RecruitmentFileDAO recruitmentFileDAO;

}
