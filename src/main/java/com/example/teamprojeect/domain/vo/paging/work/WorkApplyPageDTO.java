package com.example.teamprojeect.domain.vo.paging.work;

import com.example.teamprojeect.domain.vo.work.WorkVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkApplyPageDTO {
    private List<WorkVO> list;
    private int total;

}
