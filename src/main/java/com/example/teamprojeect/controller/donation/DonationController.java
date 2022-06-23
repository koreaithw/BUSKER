package com.example.teamprojeect.controller.donation;


import com.example.teamprojeect.domain.vo.donation.DonationVO;
import com.example.teamprojeect.service.DonationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/donation/*")
public class DonationController {

    private final DonationService donationService;

    @PostMapping(value = "/donationRegister", consumes = "application/json", produces = "text/plain; charset=utf-8")
    public void donationRegister(@RequestBody DonationVO donationVO) throws UnsupportedEncodingException {
        donationService.register(donationVO);
//        return "artist/artistInfo{query}";
    }



}
