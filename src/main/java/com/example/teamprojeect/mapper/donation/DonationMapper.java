package com.example.teamprojeect.mapper.donation;


import com.example.teamprojeect.domain.vo.donation.DonationVO;
import com.example.teamprojeect.domain.vo.show.ShowVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DonationMapper {

    public void insert(DonationVO donationVO);
}
