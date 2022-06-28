package com.example.teamprojeect.controller.ranking;


import com.example.teamprojeect.domain.vo.artist.ArtistDTO;
import com.example.teamprojeect.domain.vo.artist.ArtistVO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.service.ArtistService;
import com.example.teamprojeect.service.RankingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@Slf4j
@RequestMapping("/ranking/*")
@RequiredArgsConstructor
@Controller
public class RankingController {
    // 필드 생성
    @Autowired
    private RankingService rankingService;

    //전체 랭킹 페이지
   @GetMapping("/rankingAll")
    public String rankingListAll(Criteria criteria, Model model){
        ListDTO listDTO = new ListDTO();
        listDTO.setDetailDate("2022");
        listDTO.setRankingSortingDate("year");
        log.info(rankingService.rankingListAll(criteria,listDTO) +"hi");
        model.addAttribute("rankingListAll", rankingService.rankingListAll(criteria,listDTO));

        return "/ranking/rankingAll";
    }

    //전체 랭킹 페이지

    @GetMapping("/rankingAllImage")
    @ResponseBody
    public List<ArtistDTO> rankingListAllImage(Criteria criteria){
        ListDTO listDTO = new ListDTO();
        listDTO.setDetailDate("2022");
        listDTO.setRankingSortingDate("year");

        return rankingService.rankingListAll(criteria,listDTO);
    }



    // 뮤지션 랭킹 페이지
    @GetMapping("/rankingMusician")
    public String rankingListMusician(Criteria criteria, Model model) {
        ListDTO listDTO = new ListDTO();
        listDTO.setDetailDate("2022");
        listDTO.setRankingSortingDate("year");
        model.addAttribute("rankingListMusician", rankingService.rankingListMusician(criteria,listDTO));
       return "/ranking/rankingMusician";
    }

    // 퍼포먼스 랭킹 페이지
    @GetMapping("/rankingPerformance")
    public String rankingListPerformance(Criteria criteria, Model model) {
        ListDTO listDTO = new ListDTO();
        listDTO.setDetailDate("2022");
        listDTO.setRankingSortingDate("year");
        model.addAttribute("rankingListPerformance", rankingService.rankingListPerformance(criteria,listDTO));
       return "/ranking/rankingPerformance";
    }

    //댓글 랭킹 페이지
    @GetMapping("/rankingComment")
    public String GoRankingComment(){ return "/ranking/rankingComment";}



//    @RequestMapping(value = "ranking/rankingAll", method = {RequestMethod.GET})
//    public String test(@RequestParam("year") String year){
//       System.out.println(year);
//       return  "안녕6/27";
//    }

//    @GetMapping("ranking/rankingAll")
//    public String year(@PathVariable("") Long replyNumber){
//        log.info("read........ : " + replyNumber);
//        return rankingService.year(replyNumber);
//    }






}