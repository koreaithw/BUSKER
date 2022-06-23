package com.example.teamprojeect.domain.dao.donation;


import com.example.teamprojeect.domain.vo.donation.DonationVO;
import com.example.teamprojeect.domain.vo.show.ShowVO;
import com.example.teamprojeect.mapper.donation.DonationMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class DonationDAO {
    private final DonationMapper donationMapper;

    // 공연 등록
    public void register(DonationVO donationVO) {
        donationMapper.insert(donationVO);
    }
}
