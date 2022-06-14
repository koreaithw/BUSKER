package com.example.teamprojeect.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LikeVO {
    private Long userNumber;
    private Long artistNumber;
    private Long workNumber;
    private Long showNumber;
    private String likeDate;
    private String likeCategory;
}
