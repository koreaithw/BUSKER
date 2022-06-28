package com.example.teamprojeect.domain.vo.artist;

import com.example.teamprojeect.domain.vo.show.ShowFileVO;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ArtistVO {
    private Long artistNumber;
    private Long userNumber;
    private String userId;
    private String artistName;
    private String artistDescription;
    private Long artistType;
    private String artistDonation;
    private String artistAccount;
    private String artistStatus;
    private int likesCount;
    private Long likeDate;
    private String artistCategory;

    private ArtistFileVO file;
}
