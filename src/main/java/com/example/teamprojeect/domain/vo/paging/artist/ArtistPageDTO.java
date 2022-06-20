package com.example.teamprojeect.domain.vo.paging.artist;

import com.example.teamprojeect.domain.vo.artist.ArtistVO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtistPageDTO {
    private List<ArtistVO> list;
    private int total;

}
