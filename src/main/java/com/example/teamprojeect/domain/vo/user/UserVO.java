package com.example.teamprojeect.domain.vo.user;

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
    private String artistStatus;
    private String userEmailId;
    private String userDomain;
    private boolean userCookie;
}
