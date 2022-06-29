package com.example.teamprojeect.mapper.work;

import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.work.WorkVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WorkMapper {
    // 작품 등록 신청 및 관리자 등록 승인 (매개변수로 usreNumber를 받아서 사용자라면 등록신청을, 관리자라면 바로 등록을 실행)
    public void insertApply(WorkVO workVO);

    // 작품 수정 신청 및 관리자 수정 승인 (매개변수로 usreNumber를 받아서 사용자라면 수정신청을, 관리자라면 바로 수정을 실행)
    public int updateApply(WorkVO workVO);

    // 작품 신청 승인
    public void insertAdmin(Long workNumber);

    // 작품 수정 승인
    public void updateAdmin(Long workNumber);

    // 작품 삭제
    public int delete(Long workNumber);

    // 작품 신청 목록
    public List<WorkVO> getList(Criteria criteria); //리스트????

    // 작품 태그 검색  (태그를 선택할때마다 리스트에 추가하고, 쿼리문에서 리스트 하나씩뽑아서 if문 돌리기)
    public List<WorkVO> getKeyword(@Param("criteria") Criteria criteria, @Param("listDTO") ListDTO listDTO);

    // 작품 태그 모음
    public List<String> getTag();

    // 작품 개수
    // (매개변수 tag를 받아 null이면 전체 개수, 아니면 해당하는 인덱스만큼 list 반복을 돌려 검색)
    public int getTotal(String tag);

    // 작품 상세페이지
    public WorkVO getDetail(Long workNumber);

    public int getArtist(Long workNumber);

    // 작품 신청 개수
    public int getTotalApply();

    public int getTotalListApply();
}
