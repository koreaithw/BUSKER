package com.example.teamprojeect.controller.show;


import com.example.teamprojeect.domain.vo.artist.ArtistVO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.paging.show.ShowPageDTO;
import com.example.teamprojeect.domain.vo.show.ShowVO;
import com.example.teamprojeect.service.ArtistService;
import com.example.teamprojeect.service.ShowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/concert/*")
@Slf4j
@RequiredArgsConstructor
public class ShowController {
    // 필드 생성
    @Autowired
    private ShowService showService;
    private final ArtistService artistService;

    // 진행 예정 공연 리스트 페이지 이동
    @GetMapping("/concertPlanList")
    public String goConcertPlan(Criteria criteria, ListDTO listDTO, Model model) {
        listDTO.setArtistSortingType("NEW");
        List<ArtistVO> artistVO = artistService.getList(new Criteria(1, 3), listDTO);


        artistVO.forEach(ArtistVO -> {
            if (ArtistVO.getArtistType() == 1) {
                ArtistVO.setArtistCategory("뮤지션");
            } else if (ArtistVO.getArtistType() == 2) {
                ArtistVO.setArtistCategory("퍼포먼스");
            }
        });
        model.addAttribute("artistVO", artistVO);

        List<ShowVO> replyRankingFive = showService.getRankingReply();
//        List<ShowVO> replyRankingFive = replyRankingAll.subList(0,5);

        int count = 1;
        for(ShowVO vo : replyRankingFive) {
            log.info(vo.toString());
            log.info("ㅇ@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            log.info(count + "  들옴 ");
            vo.setReplyRanking(count);

            log.info(vo.toString());
            count += 1;
            log.info(count + "  나감 ");
        }
        replyRankingFive.forEach(showVO -> {
            // 지역만 선택
            String showRegion = showVO.getShowAddress();
            showRegion = "[" + showRegion.substring(0, 2) + "] ";
            showVO.setShowRegion(showRegion);

            // showType 문자열로 변경
            if (showVO.getShowType() == 1) {
                showVO.setShowCategory("뮤지션");
            } else if (showVO.getShowType() == 2) {
                showVO.setShowCategory("퍼포먼스");
            }

            try {
                SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
                String showDay = showVO.getShowDay();
                Date day = dayFormat.parse(showDay);
                showDay = dayFormat.format(day);

                Calendar cal = Calendar.getInstance();
                cal.setTime(day);
                int dayNum = cal.get(Calendar.DAY_OF_WEEK);
                String dayth = "";

                switch (dayNum) {
                    case 1:
                        dayth = "일";
                        break;
                    case 2:
                        dayth = "월";
                        break;
                    case 3:
                        dayth = "화";
                        break;
                    case 4:
                        dayth = "수";
                        break;
                    case 5:
                        dayth = "목";
                        break;
                    case 6:
                        dayth = "금";
                        break;
                    case 7:
                        dayth = "토";
                        break;

                }

                showDay = showDay + " (" + dayth + ")";
                showVO.setShowDay(showDay);

                SimpleDateFormat timeParse = new SimpleDateFormat("hh:mm:ss");
                SimpleDateFormat timeFormat = new SimpleDateFormat("a hh:mm", Locale.KOREAN);

                String showDate = showVO.getShowTime();
                String[] showTimeList = showDate.split("\\s+");

                Date date1 = timeParse.parse(showTimeList[1]);
                showDate = timeFormat.format(date1);

                showVO.setShowTime(showDate);

            } catch (ParseException e) {
                System.err.println("dateStr : " + ", datePattern:");
                e.printStackTrace();
            }

        });


        log.info("---------------------------------------------");
        log.info(replyRankingFive.toString());
        model.addAttribute("replyRanking", replyRankingFive);
        return "concertPlan/concertPlanList";
    }

    @GetMapping("/concertPlanList/{type}/{page}")
    @ResponseBody
    public ShowPageDTO goConcertPlanType(@PathVariable("type") String showType, @PathVariable("page") int pageNum) {
        ListDTO listDTO = new ListDTO();
        listDTO.setArtistType(showType);
        List<ShowVO> showList = showService.getList(new Criteria(pageNum, 15), listDTO);

        SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");

        showList.forEach(showVO -> {
            // 지역만 선택
            String showAddress = showVO.getShowAddress();
            showAddress = showAddress.substring(0, 2);

            String showLocation = showVO.getShowLocation();
            showLocation = "[" + showAddress + "] " + showLocation;
            showVO.setShowLocation(showLocation);

            // dday 계산
            String showDay = showVO.getShowDay();
            String todayDay = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())); // 오늘날짜

            try {
                Date date = new Date(dayFormat.parse(showDay).getTime());
                Date today = new Date(dayFormat.parse(todayDay).getTime());
                long calculate = date.getTime() - today.getTime();
                int Ddays = (int) (calculate / (24 * 60 * 60 * 1000));
                showVO.setDDay(Integer.toString(Ddays));
            } catch (ParseException e) {
                System.err.println("dateStr : " + showDay + ", datePattern:" + dayFormat);
                e.printStackTrace();
            }
        });
        return new ShowPageDTO(showList, showService.getTotal(listDTO));
    }

    // 진행중인 콘서트 페이지 이동
    @GetMapping("/concertLive")
    public String goConcertIng() {
        return "concertPlan/concertLive";
    }

    // 진행중인 콘서트 페이지
    @GetMapping("/concertLive/{region}")
    @ResponseBody
    public ShowPageDTO goConcertLive(@PathVariable("region") String region) {
        ListDTO listDTO = new ListDTO();
        listDTO.setShowLocation(region);

        List<ShowVO> showIngList = showService.getListIng(listDTO);

        showIngList.forEach(showVO -> {
            // 지역만 선택
            String showRegion = showVO.getShowAddress();
            showRegion = "[" + showRegion.substring(0, 2) + "] ";
            showVO.setShowRegion(showRegion);

            // showType 문자열로 변경
            if (showVO.getShowType() == 1) {
                showVO.setShowCategory("뮤지션");
            } else if (showVO.getShowType() == 2) {
                showVO.setShowCategory("퍼포먼스");
            }

            try {
                SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
                String showDay = showVO.getShowDay();
                Date day = dayFormat.parse(showDay);
                showDay = dayFormat.format(day);

                Calendar cal = Calendar.getInstance();
                cal.setTime(day);
                int dayNum = cal.get(Calendar.DAY_OF_WEEK);
                String dayth = "";

                switch (dayNum) {
                    case 1:
                        dayth = "일";
                        break;
                    case 2:
                        dayth = "월";
                        break;
                    case 3:
                        dayth = "화";
                        break;
                    case 4:
                        dayth = "수";
                        break;
                    case 5:
                        dayth = "목";
                        break;
                    case 6:
                        dayth = "금";
                        break;
                    case 7:
                        dayth = "토";
                        break;

                }

                showDay = showDay + " (" + dayth + ")";
                showVO.setShowDay(showDay);

                SimpleDateFormat timeParse = new SimpleDateFormat("hh:mm:ss");
                SimpleDateFormat timeFormat = new SimpleDateFormat("a hh:mm", Locale.KOREAN);

                String showDate = showVO.getShowTime();
                String[] showTimeList = showDate.split("\\s+");

                Date date1 = timeParse.parse(showTimeList[1]);
                showDate = timeFormat.format(date1);

                showVO.setShowTime(showDate);

            } catch (ParseException e) {
                System.err.println("dateStr : " + ", datePattern:");
                e.printStackTrace();
            }

        });
        return new ShowPageDTO(showIngList, showService.getTotalIng(listDTO));
    }

    // 진행 예정 공연 상세보기 페이지 이동
    @GetMapping("/concertPlanInfo")
    public String goConcertInfo(Long showNumber, Criteria criteria, HttpServletRequest request, Model model) {
        String requestURL = request.getRequestURI();

        log.info("----------------------------");
        log.info(requestURL.substring(requestURL.lastIndexOf("/")));
        log.info("----------------------------");
        log.info(criteria.toString());
        log.info("----------------------------");

        ShowVO showVO = showService.read(showNumber);

        String showRegion = showVO.getShowAddress();
        showRegion = showRegion.substring(0, 2);
        showVO.setShowRegion(showRegion);

        if (showVO.getShowType() == 1) {
            showVO.setShowCategory("뮤지션");
        } else if (showVO.getShowType() == 2) {
            showVO.setShowCategory("퍼포먼스");
        }

        try {
            SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
            String showDay = showVO.getShowDay();
            Date day = dayFormat.parse(showDay);
            showDay = dayFormat.format(day);

            Calendar cal = Calendar.getInstance();
            cal.setTime(day);
            int dayNum = cal.get(Calendar.DAY_OF_WEEK);
            String dayth = "";

            switch (dayNum) {
                case 1:
                    dayth = "일";
                    break;
                case 2:
                    dayth = "월";
                    break;
                case 3:
                    dayth = "화";
                    break;
                case 4:
                    dayth = "수";
                    break;
                case 5:
                    dayth = "목";
                    break;
                case 6:
                    dayth = "금";
                    break;
                case 7:
                    dayth = "토";
                    break;

            }

            showDay = showDay + " (" + dayth + ")";
            showVO.setShowDay(showDay);

            SimpleDateFormat timeParse = new SimpleDateFormat("hh:mm:ss");
            SimpleDateFormat timeFormat = new SimpleDateFormat("a hh:mm", Locale.KOREAN);

            String showDate = showVO.getShowTime();
            String[] showTimeList = showDate.split("\\s+");

            Date date1 = timeParse.parse(showTimeList[1]);
            showDate = timeFormat.format(date1);

            showVO.setShowTime(showDate);

        } catch (ParseException e) {
            System.err.println("dateStr : " + ", datePattern:");
            e.printStackTrace();
        }
        model.addAttribute("concert", showVO);
        return "concertPlan/concertPlanInfo";
    }

    @GetMapping("/concertInfo/{showNumber}")
    @ResponseBody
    public ShowVO goConcertInfo(@PathVariable("showNumber") Long showNumber) {

        ShowVO showVO = showService.read(showNumber);

        String showRegion = showVO.getShowAddress();
        showRegion = showRegion.substring(0, 2);
        showVO.setShowRegion(showRegion);

        if (showVO.getShowType() == 1) {
            showVO.setShowCategory("뮤지션");
        } else if (showVO.getShowType() == 2) {
            showVO.setShowCategory("퍼포먼스");
        }

        try {
            SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
            String showDay = showVO.getShowDay();
            Date day = dayFormat.parse(showDay);
            showDay = dayFormat.format(day);

            Calendar cal = Calendar.getInstance();
            cal.setTime(day);
            int dayNum = cal.get(Calendar.DAY_OF_WEEK);
            String dayth = "";

            switch (dayNum) {
                case 1:
                    dayth = "일";
                    break;
                case 2:
                    dayth = "월";
                    break;
                case 3:
                    dayth = "화";
                    break;
                case 4:
                    dayth = "수";
                    break;
                case 5:
                    dayth = "목";
                    break;
                case 6:
                    dayth = "금";
                    break;
                case 7:
                    dayth = "토";
                    break;
            }

            showDay = showDay + " (" + dayth + ")";
            showVO.setShowDay(showDay);

            SimpleDateFormat timeParse = new SimpleDateFormat("hh:mm:ss");
            SimpleDateFormat timeFormat = new SimpleDateFormat("a hh:mm", Locale.KOREAN);

            String showDate = showVO.getShowTime();
            String[] showTimeList = showDate.split("\\s+");

            Date date1 = timeParse.parse(showTimeList[1]);
            showDate = timeFormat.format(date1);

            showVO.setShowTime(showDate);

        } catch (ParseException e) {
            System.err.println("dateStr : " + ", datePattern:");
            e.printStackTrace();
        }

        return showVO;
    }

    // 진행 예정 공연 상세보기 페이지 이동
    @GetMapping("/concertPlanModify")
    public String goConcertPlanModifyPage(Long showNumber, Criteria criteria, HttpServletRequest request, Model model) {
        String requestURL = request.getRequestURI();
        log.info("----------------------------");
        log.info(requestURL.substring(requestURL.lastIndexOf("/")));
        log.info("----------------------------");
        log.info(criteria.toString());
        log.info("----------------------------");
        ShowVO showVO = showService.read(showNumber);
        if (showVO.getShowType() == 1) {
            showVO.setShowCategory("뮤지션");
        } else if (showVO.getShowType() == 2) {
            showVO.setShowCategory("퍼포먼스");
        }
        model.addAttribute("concert", showVO);
        return "concertPlan/concertPlanModify";
    }

    // 진행 예정 공연 수정 페이지 이동
    @PostMapping("/concertPlanModify")
    public RedirectView goConcertPlanModify(ShowVO showVO, Criteria criteria, RedirectAttributes rttr, HttpSession session) {
        log.info("*************");
        log.info("/modify");
        log.info("*************");
        log.info("================================");
        log.info(criteria.toString());
        log.info("================================");
        showVO.setArtistNumber(Long.valueOf(String.valueOf((session.getAttribute("artistNumber")))));
        if (showService.modify(showVO)) {
            rttr.addAttribute("showNumber", showVO.getShowNumber());
            rttr.addAttribute("pageNum", criteria.getPageNum());
            rttr.addAttribute("amount", criteria.getAmount());
        }
        return new RedirectView("/concert/concertPlanInfo");
    }

    // 진행 예정 공연 수정 완료

    // 진행 예정 공연 등록 페이지 이동
    @PostMapping("/concertPlanRegister")
    public RedirectView goConcertPlanRegister(ShowVO showVO, RedirectAttributes rttr, HttpSession session) {
        showVO.setArtistNumber(Long.valueOf(String.valueOf((session.getAttribute("artistNumber")))));
        showService.register(showVO);
        rttr.addFlashAttribute("showNumber", showVO.getShowNumber());
        return new RedirectView("/concert/concertPlanList");
    }

    @GetMapping("/concertPlanRegister")
    public String goConcertPlanRegister() {
        return "concertPlan/concertPlanRegister";
    }

    // 진행 예정 공연 등록 완료

    // 공연 삭제
    @GetMapping("/concertPlanDelete")
    public String remove(Long showNumber, Criteria criteria, ListDTO listDTO, Model model) {
        showService.remove(showNumber);
        return goConcertPlan(criteria, listDTO, model);
    }
}