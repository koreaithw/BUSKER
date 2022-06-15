package com.example.teamprojeect.domain.vo.recruitment;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RecruitmentFileVO {
    private Long recruitmentNumber;
    private String uuid;
    private String uploadPath;
    private String fileName;
}
