package com.example.teamprojeect.controller.show;


import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.paging.show.ShowPageDTO;
import com.example.teamprojeect.domain.vo.show.ShowVO;
import com.example.teamprojeect.service.ShowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/concert/*")
@Slf4j
@RequiredArgsConstructor
public class ShowController {
    // 필드 생성
    @Autowired
    private ShowService showService;

    // 진행 예정 공연 리스트 페이지 이동
    @GetMapping("/concertPlanList")
    public String goConcertPlan(Criteria criteria, ListDTO listDTO, Model model, Long showNumber) {
        List<ShowVO> showList = showService.getList(criteria, listDTO);

        SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date today = new Date();

        showList.forEach(showVO -> {
            // 지역만 선택
            String showAddress = showVO.getShowAddress();
            showAddress = showAddress.substring(0, 3);

            String showLocation = showVO.getShowLocation();
            showLocation = "[" + showAddress + "] " + showLocation;
            showVO.setShowLocation(showLocation);

            // dday 계산
            String showDay = showVO.getShowDay();

            try {
                Date showDate = dayFormat.parse(showDay);
                cal.setTime(showDate);
                cal.setTime(today);
                Long Dday = (showDate.getTime() - today.getTime())  / 1000;
                Dday =  Dday / (24*60*60);
                int showDday = Dday.intValue();
                if(Dday > 0 && Dday < 1 ) {
                    showDday = 1;
                    showVO.setDDay(showDday);
                }
                showVO.setDDay(showDday);
                log.info(Dday + "오늘날짜 dday");
                log.info(Dday + "오늘날짜 dday");
                log.info(Dday + "오늘날짜 dday");
                log.info(Dday + "오늘날짜 dday");
                log.info(Dday + "오늘날짜 dday");
            } catch (ParseException e) {
                System.err.println("dateStr : " + showDay + ", datePattern:" + dayFormat);
                e.printStackTrace();
            }
        });


        model.addAttribute("showList", showList);
        model.addAttribute("showPageDTO", new ShowPageDTO(criteria, showService.getTotal(listDTO)));
        return "concertPlan/concertPlanList";
    }

    @GetMapping("/concertPlanArtistType")
    @ResponseBody
    public String goConcertPlanA(){

        return "showService.getList()";
    }

    @GetMapping("/concertPlanMusician")
    @ResponseBody
    public String goConcertPlanM(){
        return "concertPlan/concertPlanMusician";
    }

    @GetMapping("/concertPlanPerformance")
    @ResponseBody
    public String goConcertPlanP(){
        return "concertPlan/concertPlanPerformance";
    }

    // 진행 예정 공연 상세보기 페이지 이동
    @GetMapping("/concertPlanInfo")
    public String goConcertInfo(Long showNumber, Criteria criteria, HttpServletRequest request, Model model) {
        String requestURL = request.getRequestURI();
        log.info(requestURL.substring(requestURL.lastIndexOf("/")));
        model.addAttribute("concert", showService.read(showNumber));
        return "concertPlan/concertPlanInfo";
    }

    // 진행 예정 공연 수정 페이지 이동
    @GetMapping("/concertPlanModify")
    public String goConcertPlanModify() {
        return "concertPlan/concertPlanModify";
    }

    // 진행 예정 공연 수정 완료

    // 진행 예정 공연 등록 페이지 이동
    @PostMapping("/concertPlanRegister")
    public RedirectView goConcertPlanRegister(ShowVO showVO, RedirectAttributes rttr) {
        showService.register(showVO);
        rttr.addAttribute("showNumber", showVO.getShowNumber());
        rttr.addFlashAttribute("showNumber", showVO.getShowNumber());
        return new RedirectView("concertPlan/concertPlanList");
    }

    @GetMapping("/concertPlanRegister")
    public void goConcertPlanRegister() {}

    // 진행 예정 공연 등록 완료

    // 진행중인 콘서트 페이지
    @GetMapping("/concertLive")
    public String goConcertLive() {
        return "concert/concertLive";
    }

    @PostMapping("/concertDelete")
    public String remove(Long showNumber, Criteria criteria, ListDTO listDTO, Model model) {
        showService.remove(showNumber);
        return goConcertPlan(criteria, listDTO, model, showNumber);
    }
}