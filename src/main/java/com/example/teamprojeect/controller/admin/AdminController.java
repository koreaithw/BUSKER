package com.example.teamprojeect.controller.admin;


import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.service.ArtistService;
import com.example.teamprojeect.service.RecruitService;
import com.example.teamprojeect.service.UserService;
import com.example.teamprojeect.service.WorkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/*")
public class AdminController {
    // 필드 생성
    private final ArtistService artistService;
    private final WorkService workService;
    private final RecruitService recruitService;
    private final UserService userService;

    // 관리자 페이지 이동
    @GetMapping("/adminMain")
    public String goAdmin() {
        return "/admin/adminMain";
    }

    // 아티스트 신청자 목록


    // 아티스트 등록 신청 승인


    // 아티스트 등록 신청 반려


    // 아티스트 신청 상세보기


    // 작품 신청자 목록
    @ResponseBody
    @PostMapping("/workApplyList")
    public String workApplyList(Criteria criteria) {

        return "작품 신청 목록 전체 입니다.";
    }

    // 작품 등록 신청 승인
    @ResponseBody
    @PostMapping("/workApprove/{wno}")
    public String approveWork(@PathVariable("wno") Long workNumber) {
        workService.registerAdmin(workNumber);
        return "작품 등록 신청 승인";
    }

    // 작품 등록 신청 반려
    @ResponseBody
    @PostMapping("/workReject/{wno}")
    public String rejectWork(@PathVariable("wno") Long workNumber) {
        workService.remove(workNumber);
        return "작품 등록 신청 반려";
    }

    // 작품 신청 상세보기
    @GetMapping("/registerApplyRead")
    public String getApplyInfo(Long workNumber, Model model) {
        model.addAttribute("work",workService.getDetail(workNumber));
        return "/work/workInfo";
    }

    // 모집 공고 작성


    // 모집 공고 수정


    // 모집 공고 삭제


    // 유저 목록

}
