package com.example.teamprojeect.service;

import com.example.teamprojeect.domain.vo.donation.DonationVO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class DonationServiceTests {
    @Autowired
    private DonationService donationService;

    @Test
    public void donationTest(){
        donationService.donationList(new Criteria(1, 10), 1L, new ListDTO("M", "new", "week", "new", "0")).stream().map(DonationVO::toString).forEach(log::info);
    }
}
