package com.example.teamprojeect.mapper.donation;

import com.example.teamprojeect.domain.vo.donation.DonationVO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.user.LikeVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class DonationMapperTests {
    @Autowired
    private DonationMapper donationMapper;

    @Test
    public void getLikeArtistTest(){
        donationMapper.donationList(new Criteria(1, 10), 24L, new ListDTO("M", "new", "week", "new", "0")).stream().map(DonationVO::toString).forEach(log::info);
    }
}
