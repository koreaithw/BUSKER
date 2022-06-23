package com.example.teamprojeect.controller.work;

import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.paging.PageDTO;
import com.example.teamprojeect.domain.vo.paging.work.WorkApplyPageDTO;
import com.example.teamprojeect.domain.vo.paging.work.WorkPageDTO;
import com.example.teamprojeect.domain.vo.work.WorkFileVO;
import com.example.teamprojeect.domain.vo.work.WorkVO;
import com.example.teamprojeect.service.WorkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/work/*")
public class WorkController {
    // 필드 생성
    private final WorkService workService;

    // 작품리스트 페이지 이동
    @GetMapping("/workList")
    public String goWorkList(Criteria criteria,Model model) {
        model.addAttribute("workList",workService.getKeyword(new Criteria(1, 50),new ListDTO()));
        model.addAttribute("pageDTO",new PageDTO(criteria, workService.getTotalListApply()));
        model.addAttribute("workTag", workService.getTag());
        return "/work/workList";
    }

    @ResponseBody
    @PostMapping("/workList/{tag}")
    public WorkApplyPageDTO goWorkList(@PathVariable("tag") String tag, Model model) {
        ListDTO listDTO = new ListDTO();
        if(tag != null) {
            List<String> tagList = new ArrayList<String>();
            tagList.add(tag);
            listDTO.setTag(tagList);
        }
        model.addAttribute("tagList",workService.getTag());
        return new WorkApplyPageDTO(workService.getKeyword(new Criteria(1,50),listDTO),workService.getTotalListApply());
    }

    // 작품 상세보기 페이지 이동
    @GetMapping({"/workInfo","/workUpdate"})
    public void goWorkInfo(Long workNumber, Criteria criteria, HttpServletRequest request, Model model) {
        log.info("*************");
        String requestURL = request.getRequestURI();
        log.info(requestURL.substring(requestURL.lastIndexOf("/")));
        log.info("*************");
        log.info("================================");
        log.info(criteria.toString());
        log.info("================================");
        model.addAttribute("work", workService.getDetail(workNumber));
    }

    // 작품 등록 신청 페이지 이동
    @GetMapping("/workRegister")
    public void goWorkRegister(){}

    @PostMapping("/workRegister")
    public RedirectView goWorkRegister(WorkVO workVO, WorkFileVO workFileVO, RedirectAttributes rttr) {
        workService.registerApply(workVO,workFileVO);
        return new RedirectView("/work/workList");
    }
}
