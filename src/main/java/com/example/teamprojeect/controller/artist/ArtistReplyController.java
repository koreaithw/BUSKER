package com.example.teamprojeect.controller.artist;


import com.example.teamprojeect.domain.vo.artist.ArtistReplyVO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.paging.artist.ArtistReplyPageDTO;
import com.example.teamprojeect.domain.vo.paging.show.ShowReplyPageDTO;
import com.example.teamprojeect.domain.vo.show.ShowReplyVO;
import com.example.teamprojeect.service.ArtistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/reply/artist/*")
public class ArtistReplyController {
    // 필드 생성
    @Autowired
    private ArtistService artistService;

    // 댓글 목록
    @GetMapping("/replyList/{artistNumber}/{page}")
    public ArtistReplyPageDTO getListReply(@PathVariable("artistNumber") Long artistNumber, @PathVariable("page") int pageNum) {
        List<ArtistReplyVO> artistReplyList = artistService.getListReply(new Criteria(pageNum, 10), artistNumber);


        return new ArtistReplyPageDTO(artistReplyList, artistService.getTotalReply(artistNumber));
    }

    // 댓글 입력
    @PostMapping("/replyNew")
    public ResponseEntity<String> createReply(@RequestBody ArtistReplyVO artistReplyVO) throws UnsupportedEncodingException {
        artistService.registerReply(artistReplyVO);
        return new ResponseEntity<>(new String("댓글 등록에 성공하였습니다.".getBytes(), "UTF-8"), HttpStatus.OK);
    }


    // 댓글 수정
    @PostMapping("/{replyNumber}")
    public String modifyReply(@PathVariable("replyNumber") Long replyNumber, @RequestBody ArtistReplyVO artistReplyVO) {
        artistReplyVO.setReplyNumber(replyNumber);
        artistService.modifyReply(artistReplyVO);
        return "댓글이 수정되었습니다.";
    }

    // 댓글 삭제
    @DeleteMapping("/{replyNumber}")
    public String removeReply(@PathVariable("replyNumber") Long replyNumber) {
        artistService.removeReply(replyNumber);
        return "댓글이 삭제되었습니다.";
    }






}
