package com.example.teamprojeect.domain.vo.show;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ShowFileVO {
    private Long showNumber;
    private String uuid;
    private String uploadPath;
    private String fileName;
}
