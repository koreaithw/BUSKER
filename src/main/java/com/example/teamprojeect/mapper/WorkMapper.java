package com.example.teamprojeect.mapper;

import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.work.WorkVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkMapper {
    // 작품 등록 신청
    public void insertApply(WorkVO workVO);

    // 작품 수정 신청
    public int updateApply(WorkVO workVO);

    // 작품 삭제
    public int delete(Long workNumber);

    // 작품 목록
    public List<WorkVO> getList(Criteria criteria);

    // 작품 개수 (전체)
    public int getTotal();

    // 작품 상세페이지
    public WorkVO getDetail(Long workNumber);


    // 작품 전체 검색
//    public List<WorkVO> getListSearch(Criteria criteria, String searchKeyword);

    // 작품 태그 검색  (태그를 선택할때마다 리스트에 추가하고, 쿼리문에서 리스트 하나씩뽑아서 if문 돌리기? 이거 맞는지?)
//    public List<WorkVO> getListTag(Criteria criteria, ArrayList<String> tagList);
    // 작품 태그 검색 개수
//    public int getTotalTag();
}
