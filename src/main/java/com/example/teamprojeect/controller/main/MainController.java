package com.example.teamprojeect.controller.main;

import com.example.teamprojeect.domain.vo.artist.ArtistDTO;
import com.example.teamprojeect.domain.vo.artist.ArtistVO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.show.ShowVO;
import com.example.teamprojeect.domain.vo.work.WorkVO;
import com.example.teamprojeect.service.ArtistService;
import com.example.teamprojeect.service.RankingService;
import com.example.teamprojeect.service.ShowService;
import com.example.teamprojeect.service.WorkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/main/*")
public class MainController {
    // 필드 생성


    @Autowired
    private final ArtistService artistService;
    private final ShowService showService;
    private final RankingService rankingService;
    private final WorkService workService;




    // 메인페이지 이동
    @GetMapping("/")
    public String goMain(Criteria criteria, Model model, HttpSession session, HttpServletRequest request) {

        ListDTO listDTO = new ListDTO();
        listDTO.setDetailDate("2022");
        listDTO.setRankingSortingDate("year");

        List<ShowVO> showVO = showService.getList(new Criteria(1, 5), listDTO);
        List<WorkVO> workVO = workService.getList(new Criteria(1, 5));


        model.addAttribute("rankingList", rankingService.rankingListAll(criteria,listDTO));

        model.addAttribute("showVO", showVO);
        model.addAttribute("workVO", workVO);

        log.info("showVO=========" +showVO);

        // 세션
        if(((session.getAttribute("userNumber"))==null) && (session.getAttribute("token")==null)) {
            // 일반 회원도 아니고, 토큰도 없으면, 즉
            // 로그인 안 되어 있으면
            model.addAttribute("sessionCheck", "0");
        }
        if(!(session.getAttribute("token")==null)) {
            // 카카오 토큰이 있으면
            model.addAttribute("sessionCheck", "k");
        }
        if((session.getAttribute("token")==null) && !((session.getAttribute("userNumber"))==null)) {
            // 토큰은 없는데 일반 회원이 있으면, 즉
            // 일반 회원 세션 이면
            model.addAttribute("sessionCheck", "u");
        }

        return "/main/main";
    }
}
