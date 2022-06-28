package com.example.teamprojeect.domain.vo.recruitment;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RecruitmentVO {
    private Long recruitmentNumber;
    private String recruitmentName;
    private String recruitmentLocation;
    private String recruitmentDay;
    private String recruitmentTime;
    private String recruitmentUrl;
    private String recruitmentType;
    private String recruitmentSummary;
    private String recruitmentCondition;
    private String recruitmentIntroduce;
    private String recruitmentHost;
    private String recruitmentRegisterDate;
    private String recruitmentUpdateDate;
    private String dDay;

    private RecruitmentFileVO file;
}
