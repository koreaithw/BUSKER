package com.example.teamprojeect.controller.admin;


import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.paging.PageDTO;
import com.example.teamprojeect.domain.vo.paging.work.WorkApplyPageDTO;
import com.example.teamprojeect.domain.vo.paging.work.WorkPageDTO;
import com.example.teamprojeect.service.ArtistService;
import com.example.teamprojeect.service.RecruitService;
import com.example.teamprojeect.service.UserService;
import com.example.teamprojeect.service.WorkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String goAdmin(Model model, Criteria criteria, ListDTO listDTO) {
        int total = workService.getTotalApply();
        int totalR = recruitService.getTotal(listDTO);
        // 작품 신청 전체 목록
        model.addAttribute("workList", workService.getList(criteria));
        // 관리자 페이지 메인에서 작품 신청 8개만 띄우는 목록
        model.addAttribute("workListSmall", workService.getList(new Criteria(1,8)));
        // 작품 신청 페이징
        model.addAttribute("workPageDTO", new WorkPageDTO(criteria, total));
        // 모집 공고 전체 목록
        model.addAttribute("recruitList", recruitService.getList(criteria, listDTO));
        // 관리자 페이지 메인 에서 모집공고 7개만 띄우는 목록
        model.addAttribute("recruitListSmall", recruitService.getList(new Criteria(1,7), listDTO));
        // 모집 공고 페이징
        model.addAttribute("recruitPageDTO", new PageDTO(criteria, totalR));
        return "/admin/adminMain";
    }

    // 작품 신청자 목록
    @GetMapping("/workApplyList/{page}")
    @ResponseBody
    public WorkApplyPageDTO getWorkApplyList(@PathVariable("page") int pageNum) {
        int total = workService.getTotalApply();
        return new WorkApplyPageDTO(workService.getList(new Criteria(pageNum, 10)), total);
    }

    // 작품 등록 신청 승인
    @GetMapping("/workApprove/{wno}")
    @ResponseBody
    public String approveWork(@PathVariable("wno") Long workNumber) {
        workService.registerAdmin(workNumber);
        return "작품 등록 신청이 승인되었습니다.";
    }

    // 작품 등록 신청 반려
    @GetMapping("/workReject/{wno}")
    @ResponseBody
    public String rejectWork(@PathVariable("wno") Long workNumber) {
        workService.remove(workNumber);
        return "작품 등록 신청이 반려되었습니다.";
    }

    // 작품 신청 상세보기
    @GetMapping("/registerApplyRead")
    public String getApplyInfo(Long workNumber, Model model) {
        model.addAttribute("work",workService.getDetail(workNumber));

        return "/work/workInfo";
    }

    // 아티스트 신청자 목록


    // 아티스트 등록 신청 승인


    // 아티스트 등록 신청 반려


    // 아티스트 신청 상세보기


    // 모집 공고 작성


    // 모집 공고 수정


    // 모집 공고 삭제


    // 유저 목록

}
