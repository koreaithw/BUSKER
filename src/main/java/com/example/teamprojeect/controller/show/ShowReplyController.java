package com.example.teamprojeect.controller.show;


import com.example.teamprojeect.service.ShowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/reply/concert/*")
public class ShowReplyController {
    // 필드 생성
    private ShowService concertService;
}
