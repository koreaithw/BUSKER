package com.example.teamprojeect.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class WorkFileVO {
    private Long workNumber;
    private String uuid;
    private String uploadPath;
    private String fileName;
}
