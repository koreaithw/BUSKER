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


    // 전체 랭킹 페이지 이동
//    @GetMapping("/rankingAll")
//    public String goRankingAll(Model model, ListDTO listDTO) {
////        Calendar calendar = Calendar.getInstance();
////        model.addAttribute("week", calendar.get(Calendar.WEEK_OF_MONTH));
////        model.addAttribute("month", calendar.get(Calendar.MONTH));
////        model.addAttribute("year", calendar.get(Calendar.YEAR));
//
////        dao.selectAll();
//
//        // 현재 날짜 구하기 (시스템 시계, 시스템 타임존)
//        LocalDate now = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd");
//        String formatedNow = now.format(formatter);
//        log.info("-----------------------------------------------------------------------");
//        log.info(formatedNow);
//        log.info("-----------------------------------------------------------------------");
//        LocalDate datetime = LocalDate.of(2021, 12, 25);
//        System.out.println(datetime); // 2021-12-25
//        log.info("-----------------------------------------------------------------------");
//        datetime = datetime.plusWeeks(1);
//        datetime = datetime.plusWeeks(2);
//        datetime = datetime.plusWeeks(3);
//        datetime = datetime.plusWeeks(4);
//        log.info("-----------------------------------------------------------------------");
//        DayOfWeek dayOfWeek = datetime.getDayOfWeek();
//        log.info(dayOfWeek.getDisplayName(TextStyle.FULL, Locale.KOREAN));  // 토요일
//        log.info(dayOfWeek.getDisplayName(TextStyle.NARROW, Locale.KOREAN));  // 토
//        log.info(dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.KOREAN));  // 토
//
//
////        LocalDate currentDate = LocalDate.now();
////        LocalDate targetDate = LocalDate.of(DayOfWeek getDayOfWeek())
//
//        LocalDateTime currentDateTime = LocalDateTime.now();
//        LocalDateTime targetDateTime = currentDateTime
//                .with(TemporalAdjusters.firstDayOfNextMonth());
//
//
//        LocalDateTime now1 = LocalDateTime.now();
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
//        String nowString = now1.format(dateTimeFormatter);
//        listDTO.setDetailDate(nowString);
//        log.info(nowString);
//
//
//
//
//        return "/ranking/rankingAll";
//    }

    //    랭킹 전체 목록 조회
//    @GetMapping("/rankingAll/{bno}/{page}")
//    public ListDTO getList(@PathVariable("page") int pageNum, @PathVariable("bno") Long boardBno){
//        return new ListDTO(ArtistService.getList(new Criteria(pageNum, 10), boardBno), ArtistService.getTotal(boardBno));
//    }

    // 뮤지션 랭킹 페이지
    @GetMapping("/rankingMusician")
    public String GoRankingMusician() {
        return "/ranking/rankingMusician";
    }

    // 퍼포먼스 랭킹 페이지
    @GetMapping("/rankingPerformance")
    public String GoRankingPer() {
        return "/ranking/rankingPerformance";
    }

    // 전체 랭킹 페이지 이동
//    @GetMapping("/rankingAll")
//    public String goRankingAll(Model model) {
//        Calendar calendar = Calendar.getInstance();
//        model.addAttribute("week", calendar.get(Calendar.WEEK_OF_MONTH));
//        dao.selectAll();
//        return "/ranking/rankingAll";
//    }

    @GetMapping("/rankingAll")
    public String rankingList(Criteria criteria, Model model){
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
        log.info(rankingService.rankingList(criteria,listDTO) +"hi");
        model.addAttribute("rankingList", rankingService.rankingList(criteria,listDTO));
//        model.addAttribute("ListDTO", new ListDTO(criteria, rankingService.getTotal(listDTO)));
//        model.addAttribute("ListDTO", rankingService.getTotal(listDTO));
//        List<ArtistVO> artistList = rankingService.rankingList(new Criteria(1, 10), listDTO);
        return "/ranking/rankingAll";
    }
}