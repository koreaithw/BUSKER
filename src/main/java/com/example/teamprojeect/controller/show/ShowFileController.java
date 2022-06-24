package com.example.teamprojeect.controller.show;

import com.example.teamprojeect.service.ShowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/file/concert/*")
@Controller
public class ShowFileController {
    // 필드 생성
    @Autowired
    private ShowService showService;

    // upload

    // display

    // download

    // delete

    // list

}
