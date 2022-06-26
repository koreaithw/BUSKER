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

    // 후원 목록 (유저 관점)
    public List<DonationVO> donationUserList(Criteria criteria, Long userNumber, ListDTO listDTO) { return donationDAO.donationUserList(criteria, userNumber, listDTO); }

    // 후원 개수 (유저 관점)
    public int getDonationUserTotal(Long userNumber, ListDTO listDTO) {return donationDAO.getDonationUserTotal(userNumber, listDTO); };
}
