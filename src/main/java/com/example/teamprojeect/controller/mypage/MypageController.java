package com.example.teamprojeect.controller.mypage;

import com.example.teamprojeect.domain.vo.artist.ArtistVO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.paging.user.LikePageDTO;
import com.example.teamprojeect.domain.vo.user.LikeVO;
import com.example.teamprojeect.domain.vo.user.UserVO;
import com.example.teamprojeect.service.ArtistService;
import com.example.teamprojeect.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/myPage/*")
public class MypageController {
    // 필드 생성
    private final UserService userService;
    private final ArtistService artistService;

    // 마이페이지 이동
    @GetMapping("/myPage")
    public String goMypage(Model model) {
        UserVO userVO = userService.read(24L);
        String userEmail = userVO.getUserEmail();
        String[] str = userEmail.split("@");
        userVO.setUserEmailId(str[0]);
        userVO.setUserDomain(str[1]);
        log.info(str[0]);
        model.addAttribute("user",userVO);
        return "/myPage/myPage";
    }

//    유저 정보 조회 - Talend API Tester 통과
//    @GetMapping("/{userNumber}")
//    @ResponseBody
//    public UserVO read(@PathVariable("userNumber") Long userNumber){
//        log.info("read..." + userNumber);
//        return userService.read(userNumber);
//    }

    // 유저 정보 수정 - Talend API Tester 통과
    @PatchMapping(value={"/{userNumber}"}, consumes="application/json")
    @ResponseBody
    public String modify(@PathVariable("userNumber")Long userNumber, @RequestBody UserVO userVO){
        userVO.setUserEmail(userVO.getUserEmailId() + "@" + userVO.getUserDomain());
        log.info("modify....................." + userVO);
        log.info("modify....................." + userNumber);

        userVO.setUserNumber(userNumber);
        userService.modify(userVO);
        return "유저 정보 수정 성공";
    }

    // 비밀번호 수정 - Talend API Tester 통과
    @PostMapping(value="/{userNumber}", consumes = "text/plain")
    @ResponseBody
    public String modifyPw(@PathVariable("userNumber") Long userNumber, @RequestBody String password){
        log.info("modifyPw.................." + userNumber);
        log.info("modifyPw.................." + password);

        userService.modifyPw(userNumber, password);

        return "비밀번호 수정 성공";
    }

    // 회원 탈퇴 - Talend API Tester 통과
    @DeleteMapping("/{userNumber}")
    @ResponseBody
    public String remove(@PathVariable("userNumber")Long userNumber){
        userService.remove(userNumber);
        return "유저 삭제 성공";
    }

    // 관심 아티스트 좋아요 목록 불러오기 - Talend API 통과
    @GetMapping("/{userNumber}/{type}/{page}")
    @ResponseBody
    public LikePageDTO getArtist(@PathVariable("userNumber") Long userNumber, @PathVariable ("type") String artistType, @PathVariable("page") int pageNum){
        ListDTO listDTO = new ListDTO();
        listDTO.setArtistType(artistType);

        return new LikePageDTO(userService.getLikeArtistList(new Criteria(pageNum, 10), userNumber, listDTO), userService.getTotalArtist(userNumber, listDTO));
    }

    // 관심 작품 좋아요 목록 불러오기 - Talend API 통과
    @GetMapping("/{userNumber}/{page}")
    @ResponseBody
    public LikePageDTO getWork(@PathVariable("userNumber") Long userNumber, @PathVariable("page") int pageNum){
        return new LikePageDTO(userService.getLikeWorkList(new Criteria(pageNum, 10), userNumber), userService.getTotalWork(userNumber));
    }

    // 아티스트 등록 신청
    @PostMapping(value="/new", consumes = "application/json", produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public ResponseEntity<String> create(@RequestBody ArtistVO artistVO) throws UnsupportedEncodingException{
        log.info("artistVO" + artistVO);
        artistService.registerApply(artistVO);
        return new ResponseEntity<>(new String("아티스트 등록 신청".getBytes(), "UTF-8"),HttpStatus.OK);
    }

    // 아티스트 정보 수정 신청
    @PatchMapping(value="/artist/{artistNumber}", consumes = "application/json")
    @ResponseBody
    public String modifyApply(@PathVariable("artistNumber") Long artistNumber, @RequestBody ArtistVO artistVO){
        log.info("modify..............");
        artistVO.setArtistNumber(artistNumber);
        artistService.modifyApply(artistVO);
        return "아티스트 정보 수정 성공";
    }

    // 아티스트 계정 삭제
    @DeleteMapping("/artist/remove/{artistNumber}")
    @ResponseBody
    public String removeArtist(@PathVariable("artistNumber") Long artistNumber){
        artistService.removeArtist(artistNumber);
        return "아티스트 삭제 성공";
    }
}
