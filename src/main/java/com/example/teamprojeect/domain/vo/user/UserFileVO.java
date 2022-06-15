package com.example.teamprojeect.domain.vo.user;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserFileVO {
    private Long userNumber;
    private String uuid;
    private String uploadPath;
    private String fileName;
}
