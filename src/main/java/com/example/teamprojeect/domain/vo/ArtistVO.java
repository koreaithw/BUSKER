package com.example.teamprojeect.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ArtistVO {
    private Long artistNumber;
    private Long userNumber;
    private String artistName;
    private String artistDescription;
    private Long artistStatus;
    private Long artistDonation;
    private String artistAccount;
}
