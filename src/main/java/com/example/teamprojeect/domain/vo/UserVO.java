package com.example.teamprojeect.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserVO {
    private Long userNumber;
    private String userId;
    private String userPw;
    private String userName;
    private String userPhoneNumber;
    private String userEmail;
    private Long userArtistStatus;
    private String userRegisterDate;
    private Long userStatus;
}
