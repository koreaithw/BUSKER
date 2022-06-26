package com.example.teamprojeect.controller.artist;


import com.example.teamprojeect.domain.vo.artist.ArtistVO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.paging.artist.ArtistPageDTO;
import com.example.teamprojeect.domain.vo.paging.show.ShowPageDTO;
import com.example.teamprojeect.domain.vo.show.ShowVO;
import com.example.teamprojeect.service.ArtistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/artist/*")
public class ArtistController {
    // 필드생성
    @Autowired
    private ArtistService artistService;

    // 아티스트 전체 목록 페이지
//    @GetMapping("/artistList")
//    public String goArtistList() {
//        return "/artist/artistList";
//    }


    @GetMapping("/artistList")
    public String getArtistList(){



        return "artist/artistList";
    }


    @GetMapping("/artistList/{artistSortingType}/{page}")
    @ResponseBody
    public ArtistPageDTO getArtistListType( @PathVariable("artistSortingType") String sortingType, @PathVariable("page") int pageNum){
        ListDTO listDTO = new ListDTO();
        listDTO.setArtistSortingType(sortingType);
        log.info("pageNum=================" +pageNum);
        log.info("p123=================" + sortingType);
        List<ArtistVO> artistList = artistService.getList(new Criteria(pageNum, 10), listDTO);


        return new ArtistPageDTO(artistList, artistService.getTotal(listDTO));
    }

//     아티스트 상세보기 페이지
    @GetMapping("/artistInfo")
    public String goArtistInfo(Long artistNumber, Criteria criteria, HttpServletRequest request, Model model) {
        String requestURL = request.getRequestURI();
        ArtistVO artistVO = artistService.getDetail(artistNumber);


        if(artistVO.getArtistType() == 1) {
            artistVO.setArtistCategory("뮤지션");
        } else if (artistVO.getArtistType() == 2) {
            artistVO.setArtistCategory("퍼포먼스");
        }

        Long userNumber = 1L;

        log.info("userNumber=================" + userNumber);
        log.info("artistNumber=================" + artistNumber);

        model.addAttribute("artist", artistVO);
        model.addAttribute("likeCheck", artistService.checkArtistLike(artistNumber, userNumber));

        return "artist/artistInfo";
    }




//    @GetMapping("/artistList")
//    public ArtistPageDTO getList(@RequestParam("page") int pageNum, @RequestParam("artistSortingType") ListDTO listDTO){
//
//
//        return new ArtistPageDTO(artistService.getList(new Criteria(pageNum, 5), listDTO), artistService.getTotal(listDTO));
//    }

//
//    // 아티스트 상세보기 페이지
//    @GetMapping("/artistInfo")
//    public String goArtistInfo() {
//        return "/artist/artistInfo";
//    }
//
//    // 뮤지션 목록 페이지
//    @GetMapping("/artistListMusician")
//    public String goArListMusician() {
//        return "/artist/artistListMusician";
//    }
//
//    // 퍼포먼스 아티스트 목록 페이지
//    @GetMapping("/artistListPerformance")
//    public String goArListPerformance() {
//        return "/artist/artistListPerformance";
//    }
//



}
