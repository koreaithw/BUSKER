package com.example.teamprojeect.mapper;

import com.example.teamprojeect.domain.vo.ArtistVO;
import com.example.teamprojeect.domain.vo.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RankingMapper {
    // 주간 랭킹 목록 (전체)
    public List<ArtistVO> weekRangking(Criteria criteria, String week);

    // 주간 랭킹 목록 (뮤지션, 퍼포먼스 구분)
    public List<ArtistVO> weekRangking(Criteria criteria, String week, String artistStatus);

    // 월간 랭킹 목록 (전체)
    public List<ArtistVO> monthRangking(Criteria criteria, String month);

    // 월간 랭킹 목록 (뮤지션, 퍼포먼스 구분)
    public List<ArtistVO> monthRangking(Criteria criteria, String month, String artistStatus);


    // 누적 랭킹 목록 (전체)
    public List<ArtistVO> allRangking(Criteria criteria);

    // 누적 랭킹 목록 (뮤지션, 퍼포먼스 구분)
    public List<ArtistVO> allRangking(Criteria criteria, String artistStatus);
}
