package com.example.teamprojeect.controller.artist;


import com.example.teamprojeect.domain.vo.artist.ArtistVO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.paging.artist.ArtistPageDTO;
import com.example.teamprojeect.service.ArtistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/artist/*")
public class ArtistController {
    // 필드생성
    @Autowired
    private ArtistService artistService;

    // 아티스트 전체 목록 페이지
//    @GetMapping("/artistList")
//    public String goArtistList() {
//        return "/artist/artistList";
//    }


    @GetMapping("/artistList")
    public String getArtistList(Model model, @RequestParam("page") int pageNum, @RequestParam("artistSortingType") ListDTO listDTO){
        List<ArtistVO> artistList = artistService.getList(new Criteria(pageNum, 5), listDTO);

        model.addAttribute("artistList", artistList);

        return "artist/artistList";


    }

//    @GetMapping("/artistList")
//    public ArtistPageDTO getList(@RequestParam("page") int pageNum, @RequestParam("artistSortingType") ListDTO listDTO){
//
//
//        return new ArtistPageDTO(artistService.getList(new Criteria(pageNum, 5), listDTO), artistService.getTotal(listDTO));
//    }

//
//    // 아티스트 상세보기 페이지
//    @GetMapping("/artistInfo")
//    public String goArtistInfo() {
//        return "/artist/artistInfo";
//    }
//
//    // 뮤지션 목록 페이지
//    @GetMapping("/artistListMusician")
//    public String goArListMusician() {
//        return "/artist/artistListMusician";
//    }
//
//    // 퍼포먼스 아티스트 목록 페이지
//    @GetMapping("/artistListPerformance")
//    public String goArListPerformance() {
//        return "/artist/artistListPerformance";
//    }
//



}
