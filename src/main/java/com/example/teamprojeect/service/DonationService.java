package com.example.teamprojeect.service;


import com.example.teamprojeect.domain.dao.donation.DonationDAO;
import com.example.teamprojeect.domain.vo.donation.DonationVO;
import com.example.teamprojeect.domain.vo.show.ShowVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DonationService {
    private final DonationDAO donationDAO;

    public void register(DonationVO donationVO) {
        donationDAO.register(donationVO);
    }
}
