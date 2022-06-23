package com.example.teamprojeect.domain.vo.paging.user;

import com.example.teamprojeect.domain.vo.user.LikeVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikePageDTO {
    private List<LikeVO> list;
    private int total;
}
