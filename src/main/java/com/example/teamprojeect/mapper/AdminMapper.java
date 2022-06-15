package com.example.teamprojeect.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    // 관리자 아티스트 등록 / 수정 수락
//    public void insert(ArtistVO artistVO); // 관리자가 직접 등록할 일이 있다면 매개변수를 이렇게 정의
    public void insert(Long artistNumber); // 관리자가 허가만 해 준다면 artistNumber만 받아서 status를 변경해 주면 됨

    // 관리자 작품 등록 / 수정 수락
//    public int update(WorkVO workVO);  // 관리자가 직접 등록할 일이 있다면 매개변수를 이렇게 정의
    public int update(Long workNumber); // 관리자가 허가만 해 준다면 workNumber 받아서 status를 변경해 주면 됨
}
