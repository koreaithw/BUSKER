package com.example.teamprojeect.controller.ranking;


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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    //전체 랭킹 페이지지
   @GetMapping("/rankingAll")
    public String rankingListAll(Criteria criteria, Model model){
        ListDTO listDTO = new ListDTO();
        listDTO.setDetailDate("2022");
        listDTO.setRankingSortingDate("year");
        log.info("*************");
        log.info("/rankinglist");
        log.info("*************");
        log.info(String.valueOf(listDTO));
        log.info("*************");
        log.info(String.valueOf(criteria));
        log.info("*************");
        log.info("*************");
        log.info(rankingService.rankingListAll(criteria,listDTO) +"hi");
        model.addAttribute("rankingListAll", rankingService.rankingListAll(criteria,listDTO));

        return "/ranking/rankingAll";
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




}