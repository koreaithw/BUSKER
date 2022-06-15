package com.example.teamprojeect.domain.vo.list;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ListDTO {
    private String artistType;
    private String sortingType;
    private String sortingDate;
    private String ingWhether;
    private String showType;
    private String donationType;
    private String likeType;
    private String tag;
    private String recruitmentType;
}
