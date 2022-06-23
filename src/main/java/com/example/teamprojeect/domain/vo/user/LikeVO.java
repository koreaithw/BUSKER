package com.example.teamprojeect.domain.vo.user;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LikeVO {
    private Long userNumber;
    private Long artistNumber;
    private Long workNumber;
    private String likeDate;
    private String likeCategory;
    private String artistName;
    private String artistType;
    private String workName;
}
