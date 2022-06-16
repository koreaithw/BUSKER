package com.example.teamprojeect.controller.work;

import com.example.teamprojeect.service.WorkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/work/*")
public class WorkController {
    // 필드 생성
    private final WorkService workService;

    // 작품리스트 페이지 이동
    @GetMapping("/workList")
    public String goWorkList() {
        return "/work/workList";
    }

    // 작품 상세보기 페이지 이동
    @GetMapping("/workInfo")
    public String goWorkInfo() {
        return "/work/workInfo";
    }

    // 작품 등록 신청 페이지 이동
    @GetMapping("/workRegister")
    public String goWorkRegister() {
        return "/work/workRegister";
    }
}
