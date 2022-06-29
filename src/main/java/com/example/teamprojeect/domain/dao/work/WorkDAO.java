package com.example.teamprojeect.domain.dao.work;

import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.work.WorkVO;
import com.example.teamprojeect.mapper.work.WorkMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@Slf4j
public class WorkDAO {
    private final WorkMapper workMapper;

    // 작품 등록 신청 및 관리자 등록 승인 (매개변수로 usreNumber를 받아서 사용자라면 등록신청을, 관리자라면 바로 등록을 실행)
    public void registerApply(WorkVO workVO) {
        workMapper.insertApply(workVO);
    };

    // 작품 등록 신청 승인
    public void registerAdmin(Long workNumber) {
        workMapper.insertAdmin(workNumber);
    }

    // 작품 수정 신청 및 관리자 수정 승인 (매개변수로 usreNumber를 받아서 사용자라면 수정신청을, 관리자라면 바로 수정을 실행)
    public boolean modifyApply(WorkVO workVO) {
        return workMapper.updateApply(workVO) == 1;
    }

    // 작품 수정 신청 승인
    public void modifyAdmin(Long workNumber) { workMapper.updateAdmin(workNumber);
    }

    // 작품 삭제
    public boolean remove(Long workNumber) {
        return workMapper.delete(workNumber) == 1;
    }

    // 작품 신청 전체 목록
    public List<WorkVO> getList(Criteria criteria){
        return workMapper.getList(criteria);
    } //리스트????

    // 작품 태그 검색  (태그를 선택할때마다 리스트에 추가하고, 쿼리문에서 리스트 하나씩뽑아서 if문 돌리기)
    public List<WorkVO> getKeyword(Criteria criteria, ListDTO listDTO) { return workMapper.getKeyword(criteria,listDTO);}

    // 작품 태그
    public List<String> getTag() {
        List<String> tag = workMapper.getTag();
        List<String> arr = new ArrayList<String>();
        for (int i = 0; i < tag.size() ; i++){ // 태그 #를 기준으로 나눠서 문자열 리스트로 보내주기
            String str[] = tag.get(i).split("#");
            for(int j = 0; j <str.length; j++) {
                arr.add(str[j]);
            }
        }
        List<String> list = arr.stream().distinct().collect(Collectors.toList());
        log.info(list.toString());
        return list;
    }

    // 작품 개수
    // (매개변수 tag를 받아 null이면 전체 개수, 아니면 해당하는 인덱스만큼 list 반복을 돌려 검색)
    public int getTotal(String tag) {
        return workMapper.getTotal(tag);
    }

    // 작품 상세페이지
    public WorkVO getDetail(Long workNumber) {
        return workMapper.getDetail(workNumber);
    }

    public int getArtist(Long workNumber){
        return workMapper.getArtist(workNumber);
    };

    // 작품 신청 개수
    public int getTotalApply() {
        return workMapper.getTotalApply();
    }

    public int getTotalListApply() {
        return workMapper.getTotalListApply();
    }

}
