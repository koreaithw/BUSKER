package com.example.teamprojeect.domain.dao.donation;


import com.example.teamprojeect.domain.vo.donation.DonationVO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.show.ShowVO;
import com.example.teamprojeect.mapper.donation.DonationMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class DonationDAO {
    private final DonationMapper donationMapper;

    // 공연 등록
    public void register(DonationVO donationVO) {
        donationMapper.insert(donationVO);
    }

    // 후원 목록
    public List<DonationVO> donationList(@Param("criteria")Criteria criteria, @Param("artistNumber")Long artistNumber, @Param("listDTO")ListDTO listDTO){
        return donationMapper.donationList(criteria, artistNumber, listDTO);
    }

    // 후원 개수
    public int getDonationTotal(@Param("artistNumber")Long artistNumber, @Param("listDTO")ListDTO listDTO){
        return donationMapper.getDonationTotal(artistNumber, listDTO);
    }
}
