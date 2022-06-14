package com.example.teamprojeect.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/concert/*")
@Slf4j
@RequiredArgsConstructor
public class ConcertController {
}
