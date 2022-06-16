package com.example.teamprojeect.controller.admin;


import com.example.teamprojeect.service.ArtistService;
import com.example.teamprojeect.service.RecruitService;
import com.example.teamprojeect.service.WorkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/*")
public class AdminController {
    // 필드 생성
    private final ArtistService artistService;
    private final WorkService workService;
    private final RecruitService recruitService;

    // 관리자 페이지 이동
    @GetMapping("/adminMain")
    public String goAdmin() {
        return "/admin/adminMain";
    }

    // 아티스트 신청자 목록


    // 아티스트 등록 신청 승인


    // 아티스트 등록 신청 반려


    // 작품 신청자 목록


    // 작품 등록 신청 승인


    // 작품 등록 신청 반려


    // 모집 공고 작성


    // 모집 공고 수정


    // 모집 공고 삭제


}
