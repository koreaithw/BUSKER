package com.example.teamprojeect.domain.vo.paging.recruitment;


import com.example.teamprojeect.domain.vo.recruitment.RecruitmentVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecruitListPageDTO {
    private List<RecruitmentVO> list;
    private int total;
}
