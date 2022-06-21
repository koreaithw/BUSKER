package com.example.teamprojeect.controller.recruit;


import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.paging.recruitment.RecruitmentPageDTO;
import com.example.teamprojeect.domain.vo.recruitment.RecruitmentFileVO;
import com.example.teamprojeect.domain.vo.recruitment.RecruitmentVO;
import com.example.teamprojeect.service.RecruitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/recruit/*")
public class RecruitmentController {
    // 필드 생성
    private final RecruitService recruitService;

    // 모집공고 페이지 이동
    @GetMapping("/recruitList")
    public String goRecruit(Criteria criteria, Model model) {
        log.info("*************");
        log.info("/list");
        log.info("*************");
        model.addAttribute("recruitList", recruitService.getList(criteria,new ListDTO()));
        model.addAttribute("pageDTO", new RecruitmentPageDTO(criteria, recruitService.getTotal(new ListDTO())));
        return "/recruit/recruitList";
    }

    // 모집공고 상세페이지 이동
    @GetMapping("/recruitInfo")
    public void goRecruitInfo(Long recruitmentNumber, Criteria criteria, HttpServletRequest request, Model model) {
        log.info("*************");
        String requestURL = request.getRequestURI();
        log.info(requestURL.substring(requestURL.lastIndexOf("/")));
        log.info("*************");
        log.info("================================");
        log.info(criteria.toString());
        log.info("================================");
        model.addAttribute("recruitment", recruitService.getDetail(recruitmentNumber));
    }

    @GetMapping("/recruitRegister")
    public void goRecruitRegister(){}

    // 모집공고 등록 페이지 이동
    @PostMapping("/recruitRegister")
    public RedirectView goRecruitRegister(RecruitmentVO recruitmentVO, RecruitmentFileVO recruitmentFileVO, RedirectAttributes rttr) {
        log.info("*************");
        log.info("/register");
        log.info("*************");
        recruitService.register(recruitmentVO, recruitmentFileVO);
        rttr.addFlashAttribute("recruitmentNumber",recruitmentVO.getRecruitmentNumber());
        return new RedirectView("/recruit/recruitList");
    }

    // 모집공고 수정 페이지 이동
    @GetMapping("/recruitUpdate")
    public RedirectView goRecruitUpdate(RecruitmentVO recruitmentVO, Criteria criteria, RedirectAttributes rttr) {
        log.info("*************");
        log.info("/modify");
        log.info("*************");
        log.info("================================");
        log.info(criteria.toString());
        log.info("================================");
        if(recruitService.modify(recruitmentVO)) {
            rttr.addAttribute("recruitmentNumber",recruitmentVO.getRecruitmentNumber());
            rttr.addAttribute("pageNum",criteria.getPageNum());
            rttr.addAttribute("amount",criteria.getAmount());
        }
        return new RedirectView("/recruit/recruitInfo");
    }

}
