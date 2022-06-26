package com.example.teamprojeect.domain.vo.donation;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class DonationVO {
    private Long donationNumber;
    private Long userNumber;
    private Long artistNumber;
    private Long donationMoney;
    private String donationMessage;
    private String donationRegisterDate;
    private String userName;
    private String donationType;
    private String artistName;
}
