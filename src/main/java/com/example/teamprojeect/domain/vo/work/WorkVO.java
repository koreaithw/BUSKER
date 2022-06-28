package com.example.teamprojeect.domain.vo.work;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class WorkVO {
    private Long workNumber;
    private Long artistNumber;
    private String artistName;
    private String workName;
    private String workGenre;
    private String workDescription;
    private String workYoutubeUrl;
    private String workPurchaseUrl;
    private String workTag;
    private String workReleaseDate;
    private String workRegisterDate;
    private String workUpdateDate;
    private String workStatus;

    private WorkFileVO file;
}

