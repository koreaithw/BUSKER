package com.example.teamprojeect.controller.recruit;


import com.example.teamprojeect.service.RecruitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/recruit/*")
public class RecruitmentController {
    // 필드 생성
    private final RecruitService recruitService;

    // 모집공고 페이지 이동
    @GetMapping("/recruitList")
    public String goRecruit() {
        return "/recruit/recruitList";
    }

    // 모집공고 상세페이지 이동
    @GetMapping("/recruitInfo")
    public String goRecruitInfo() {
        return "/recruit/recruitInfo";
    }

    // 모집공고 등록 페이지 이동
    @GetMapping("/recruitRegister")
    public String goRecruitRegister() {
        return "/recruit/recruitRegister";
    }

    // 모집공고 수정 페이지 이동
    @GetMapping("/recruitUpdate")
    public String goRecruitUpdate() {
        return "/recruit/recruitRegister";
    }

}
