package com.example.teamprojeect.controller.user;

import com.example.teamprojeect.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/file/user/*")
@Controller
public class UserFileController {
    // 필드 생성
    private final UserService userService;


}
