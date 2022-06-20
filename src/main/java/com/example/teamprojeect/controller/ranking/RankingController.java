package com.example.teamprojeect.controller.ranking;


import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.service.RankingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Locale;

@Slf4j
@RequestMapping("/ranking/*")
@RequiredArgsConstructor
@Controller
public class RankingController {
    // 필드 생성
    private RankingService rankingService;

    // 전체 랭킹 페이지 이동
    @GetMapping("/rankingAll")
    public String goRankingAll(Model model, ListDTO listDTO) {
//        Calendar calendar = Calendar.getInstance();
//        model.addAttribute("week", calendar.get(Calendar.WEEK_OF_MONTH));
//        model.addAttribute("month", calendar.get(Calendar.MONTH));
//        model.addAttribute("year", calendar.get(Calendar.YEAR));

//        dao.selectAll();

        // 현재 날짜 구하기 (시스템 시계, 시스템 타임존)
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd");
        String formatedNow = now.format(formatter);
        log.info("-----------------------------------------------------------------------");
        log.info(formatedNow);
        log.info("-----------------------------------------------------------------------");
        LocalDate datetime = LocalDate.of(2021, 12, 25);
        System.out.println(datetime); // 2021-12-25
        log.info("-----------------------------------------------------------------------");
        datetime = datetime.plusWeeks(1);
        datetime = datetime.plusWeeks(2);
        datetime = datetime.plusWeeks(3);
        datetime = datetime.plusWeeks(4);
        log.info("-----------------------------------------------------------------------");
        DayOfWeek dayOfWeek = datetime.getDayOfWeek();
        log.info(dayOfWeek.getDisplayName(TextStyle.FULL, Locale.KOREAN));  // 토요일
        log.info(dayOfWeek.getDisplayName(TextStyle.NARROW, Locale.KOREAN));  // 토
        log.info(dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.KOREAN));  // 토


//        LocalDate currentDate = LocalDate.now();
//        LocalDate targetDate = LocalDate.of(DayOfWeek getDayOfWeek())

        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime targetDateTime = currentDateTime
                .with(TemporalAdjusters.firstDayOfNextMonth());


        LocalDateTime now1 = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        String nowString = now1.format(dateTimeFormatter);
        listDTO.setDetailDate(nowString);
        log.info(nowString);




        return "/ranking/rankingAll";
    }

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
}