package com.example.teamprojeect.service;


import com.example.teamprojeect.domain.dao.donation.DonationDAO;
import com.example.teamprojeect.domain.vo.donation.DonationVO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.show.ShowVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonationService {
    private final DonationDAO donationDAO;

    public void register(DonationVO donationVO) {
        donationDAO.register(donationVO);
    }

    // 후원 목록
    public List<DonationVO> donationList(Criteria criteria, Long artistNumber, ListDTO listDTO) { return donationDAO.donationList(criteria, artistNumber, listDTO); }

    // 후원 개수
    public int getDonationTotal(Long artistNumber, ListDTO listDTO) {return donationDAO.getDonationTotal(artistNumber, listDTO); };
}
