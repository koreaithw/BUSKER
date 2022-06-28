package com.example.teamprojeect.controller.artist;


import com.example.teamprojeect.domain.vo.artist.ArtistReplyVO;
import com.example.teamprojeect.domain.vo.artist.ArtistVO;
import com.example.teamprojeect.domain.vo.donation.DonationVO;
import com.example.teamprojeect.domain.vo.user.LikeVO;
import com.example.teamprojeect.service.ArtistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/like/artist/*")
public class ArtistLikeController {
    // 필드
    private final ArtistService artistService;

    // 좋아요 등록
//    @PostMapping("/likeNew")
//    public ResponseEntity<String> createLike(@RequestBody LikeVO likeVO) throws UnsupportedEncodingException {
//        artistService.registerUserLike(likeVO);
//        return new ResponseEntity<>(new String("해당 아티스트에 좋아요를 눌렀습니다.".getBytes(), "UTF-8"), HttpStatus.OK);
//    }

    @PostMapping(value = "/likeNew", consumes = "application/json", produces = "text/plain; charset=utf-8")
    public void likeRegister(@RequestBody LikeVO likeVO) throws UnsupportedEncodingException {
        artistService.registerUserLike(likeVO);

    }

    @PostMapping(value = "/likeDelete", consumes = "application/json", produces = "text/plain; charset=utf-8")
    public void likeRemove(@RequestBody LikeVO likeVO) throws UnsupportedEncodingException {
        artistService.removeUserLike(likeVO);

    }

    @PostMapping(value = "/likeCount", consumes = "application/json", produces = "text/plain; charset=utf-8")
    public int artistLikeCount(@RequestBody Long artistNumber) throws UnsupportedEncodingException {
        return artistService.artistLikeCount(artistNumber);

    }


    // 좋아요 취소


    // 받은 좋아요 개수
}
