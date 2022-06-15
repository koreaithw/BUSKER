package com.example.teamprojeect.controller.ranking;


import com.example.teamprojeect.service.RankingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/ranking/*")
@RequiredArgsConstructor
@Controller
public class RankingController {
    // 필드 생성
    private RankingService rankingService;

    // 전체 랭킹 페이지 이동
    @GetMapping("/rankingAll")
    public String goRankingAll() {
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
}
