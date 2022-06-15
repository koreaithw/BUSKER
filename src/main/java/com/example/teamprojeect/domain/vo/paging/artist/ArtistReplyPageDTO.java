package com.example.teamprojeect.domain.vo.paging.artist;

import com.example.teamprojeect.domain.vo.artist.ArtistReplyVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtistReplyPageDTO {
    private List<ArtistReplyVO> list;
    private int total;
}