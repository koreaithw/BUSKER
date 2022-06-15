package com.example.teamprojeect.domain.vo.artist;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ArtistFileVO {
    private Long artistNumber;
    private String uuid;
    private String uploadPath;
    private String fileName;
}
