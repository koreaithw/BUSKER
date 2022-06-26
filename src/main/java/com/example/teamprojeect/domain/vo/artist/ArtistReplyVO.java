package com.example.teamprojeect.domain.vo.artist;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ArtistReplyVO {
    private Long replyNumber;
    private Long userNumber;
    private Long artistNumber;
    private String replyContent;
    private String replyRegisterDate;
    private String replyUpdateDate;
    private String artistType;
    private String artistName;
    private String userName;

}
