package com.example.teamprojeect.controller.show;


import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.paging.show.ShowReplyPageDTO;
import com.example.teamprojeect.domain.vo.show.ShowReplyVO;
import com.example.teamprojeect.service.ShowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/reply/concert/*")
public class ShowReplyController {
    @Autowired
    private ShowService showService;

    // 댓글 목록
    @GetMapping("/replyList/{showNumber}/{page}")
    public ShowReplyPageDTO getListReply(@PathVariable("showNumber") Long showNumber, @PathVariable("page") int pageNum) {
            List<ShowReplyVO> showReplyList = showService.getListReply(new Criteria(pageNum, 10), showNumber);

        showReplyList.forEach(showReplyVO -> {
            try {
                SimpleDateFormat rowFormate = new SimpleDateFormat("yyyy-MM-dd HH24:mm:ss");
                SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy.MM.dd a HH:mm");
                String replyRegisterDate = showReplyVO.getReplyRegisterDate();
                String replyUpdateDate = showReplyVO.getReplyUpdateDate();

                Date replyRegisterDateParse = rowFormate.parse(replyRegisterDate);
                Date replyUpdateDateParse = dayFormat.parse(replyUpdateDate);

                replyRegisterDate = rowFormate.format(replyRegisterDateParse);
                replyUpdateDate = dayFormat.format(replyUpdateDateParse);

                showReplyVO.setReplyRegisterDate(replyRegisterDate);
                showReplyVO.setReplyUpdateDate(replyUpdateDate);
            } catch (ParseException e) {
                System.err.println("dateStr : " + ", datePattern:");
                e.printStackTrace();
            }
        });
        return new ShowReplyPageDTO(showReplyList, showService.getTotalReply(showNumber));
    }

    // 댓글 입력
    @PostMapping("/replyNew")
    public ResponseEntity<String> createReply(@RequestBody ShowReplyVO showReplyVO) throws UnsupportedEncodingException {
        showService.registerReply(showReplyVO);
        return new ResponseEntity<>(new String("댓글 등록에 성공하였습니다.".getBytes(), "UTF-8"), HttpStatus.OK);
    }


    // 댓글 수정
    @PostMapping("/{replyNumber}")
    public String modifyReply(@PathVariable("replyNumber") Long replyNumber, @RequestBody ShowReplyVO showReplyVO) {
        showReplyVO.setReplyNumber(replyNumber);
        showService.modifyReply(showReplyVO);
        return "댓글이 수정되었습니다.";
    }

    // 댓글 삭제
    @DeleteMapping("/{replyNumber}")
    public String removeReply(@PathVariable("replyNumber") Long replyNumber) {
        showService.removeReply(replyNumber);
        return "댓글이 삭제되었습니다.";
    }
}
