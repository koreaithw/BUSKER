package com.example.teamprojeect.domain.vo.list;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
public class ListDTO {
    //    공용
    //    아티스트 타입
    private String artistType;
    // 전체 : 'A' (기본값)
    // 뮤지션 : 'M'
    // 퍼포먼스 : 'P'


    /////////    마이페이지
    // 나의 후원 & 후원 회원 목록
    private String donationType;
    // 최신순 : 'new' (기본값)
    // 오래된 순 : 'old'
    // 금액 높은 순 : 'expensive'
    // 금액 낮은 순 : 'cheap'

    // 회원이 아티스트 계정을 클릭했을 때 artist계정인지 아닌지 판단
    private String artistUserStatusType;
    // 아티스트 등록된 회원이면 'Y'
    // 등록되지 않은 회원이면 'N'

    // 관심 아티스트 또는 관심 작품
    private String likeCategory;
    // 기본값 없음 (클릭에 따라 달라짐)
    // 아티스트 : 'A'
    // 작품 : 'W'

    ///////// 로그인
    // ID, PW 찾기
    private String findWay;
    // 아이디 찾기 클릭 : 'id'
    // 비번 찾기 클릭 : 'pw'

    /////////    아티스트 정보
    private String artistSortingType;
    // 최신순 : 'new" (기본값)
    // 인기순 : 'like'


    /////////    아티스트 랭킹
    private String rankingSortingDate;
    // 주간 : 'week' (기본값)
    // 월간 : 'month'
    // 연간 : 'year'

    /////////    공연
    private String ingWhether;
    // 진행 예정 : 'yet'
    // 진행 중 : 'ing'
    private String showSortingType;


    /////////    작품
    private List<String> tag;

    /////////    모집공고 : 공용 artistType 사용


    public ListDTO() { this("A", "new", "week", "new");}
    public ListDTO(String artistType, String donationType, String rankingSortingDate, String artistSortingType) {
        this.artistType = artistType;
        this.donationType = donationType;
        this.artistSortingType = artistSortingType;
        this.rankingSortingDate = rankingSortingDate;
    }
}