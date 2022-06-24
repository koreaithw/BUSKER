package com.example.teamprojeect.mapper.donation;


import com.example.teamprojeect.domain.vo.donation.DonationVO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.show.ShowVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DonationMapper {

    // 후원 등록
    public void insert(DonationVO donationVO);

    // 후원 목록 불러오기
    public List<DonationVO> donationList(@Param("criteria") Criteria criteria, @Param("artistNumber") Long artistNumber, @Param("listDTO")ListDTO listDTO);
}
