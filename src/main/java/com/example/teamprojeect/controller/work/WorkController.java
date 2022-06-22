package com.example.teamprojeect.controller.work;

import com.example.teamprojeect.domain.vo.work.WorkFileVO;
import com.example.teamprojeect.domain.vo.work.WorkVO;
import com.example.teamprojeect.service.WorkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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
    public void goWorkRegister(){}

    @PostMapping("/workRegister")
    public RedirectView goWorkRegister(WorkVO workVO, WorkFileVO workFileVO, RedirectAttributes rttr) {
        workService.registerApply(workVO,workFileVO);
        rttr.addFlashAttribute("workNumber",workVO.getWorkNumber());
        return new RedirectView("/work/workList");
    }
}
