package com.example.teamprojeect.controller.concert;


import com.example.teamprojeect.service.ConcertService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/concert/*")
@Slf4j
@RequiredArgsConstructor
public class ConcertController {
    // 필드 생성
    private ConcertService concertService;

    // 진행 예정 공연 리스트 페이지 이동
    @GetMapping("/concertPlanList")
    public String goConcertPlan(){
        return "/concert/concertPlanList";
    }

    @GetMapping("/concertPlanMusician")
    public String goConcertPlanM(){
        return "/concert/concertPlanMusician";
    }


    @GetMapping("/concertPlanPerformance")
    public String goConcertPlanP(){
        return "/concert/concertPlanPerformance";
    }


    // 진행 예정 공연 상세보기 페이지 이동
    @GetMapping("/concertPlanInfo")
    public String goConcertInfo() {
        return "/concert/concertPlanInfo";
    }

    // 진행 예정 공연 수정 페이지 이동
    @GetMapping("/concertPlanModify")
    public String goConcertPlanModify() {
        return "/concert/concertPlanModify";
    }

    // 진행 예정 공연 수정 완료

    // 진행 예정 공연 등록 페이지 이동
    @GetMapping("/concertPlanRegister")
    public String goConcertPlanRegister() {
        return "/concert/concertPlanRegister";
    }

    // 진행 예정 공연 등록 완료

    // 진행중인 콘서트 페이지
    @GetMapping("/concertLive")
    public String goConcertLive() {
        return "/concert/concertLive";
    }
}
