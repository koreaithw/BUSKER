package com.example.teamprojeect.domain.vo.paging.show;

import com.example.teamprojeect.domain.vo.show.ShowReplyVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowReplyPageDTO {
    private List<ShowReplyVO> list;
    private int total;
}