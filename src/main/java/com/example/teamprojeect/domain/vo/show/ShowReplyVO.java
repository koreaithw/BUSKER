package com.example.teamprojeect.domain.vo.show;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ShowReplyVO {
    private Long replyNumber;
    private Long userNumber;
    private Long showNumber;
    private String replyContent;
    private String replyRegisterDate;
    private String replyUpdateDate;
    private String userName;
    private String showType;
    private String showName;
}
