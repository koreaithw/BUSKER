package com.example.teamprojeect.domain.vo.artist;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ArtistDTO {
        private Long artistNumber;
        private Long userNumber;
        private String artistName;
        private String artistDescription;
        private Long artistType;
        private String artistDonation;
        private String artistAccount;
        private String artistStatus;
        private Long likescount;
        private Long likeDate;
        private String artistCategory;
        private Long rankingCount;
    }
