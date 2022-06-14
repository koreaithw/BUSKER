package com.example.teamprojeect.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RecruitmentVO {
    private Long recruitmentNumber;
    private String recruitmentName;
    private String recruitmentContent;
    private String recruitmentUrl;
    private String recruitmentStatus;
    private String recruitmentRegisterDate;
    private String recruitmentUpdateDate;
}
