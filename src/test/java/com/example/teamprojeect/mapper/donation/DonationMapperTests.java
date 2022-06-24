package com.example.teamprojeect.mapper.donation;

import com.example.teamprojeect.domain.vo.donation.DonationVO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.user.LikeVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class DonationMapperTests {
    @Autowired
    private DonationMapper donationMapper;

    @Test
    public void donationTest(){
        donationMapper.donationList(new Criteria(1, 10), 1L, new ListDTO("M", "new", "week", "new", "0")).stream().map(DonationVO::toString).forEach(log::info);
    }

    // 후원 목록 전체 개수
    @Test
    public void getDonationTotal(){
        ListDTO listDTO = new ListDTO();
        Long artistNumber = 1L;
        listDTO.setDonationType("new");
        donationMapper.getDonationTotal(artistNumber, listDTO);
    }
}
