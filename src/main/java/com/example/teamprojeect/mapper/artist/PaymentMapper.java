package com.example.teamprojeect.mapper.artist;

import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.artist.PaymentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaymentMapper {
    // 후원 결제
    public void pay(PaymentVO paymentVO);

    // 후원 결제 취소
    public void refund(Long paymentNumber);

    // 후원 목록
    // (매개변수로 donationType을 받아 내가한후원 / 후원회원목록 선택)
    // (매개변수로 userNumber를 받아 이 번호에 해당하는 정보를 출력.
    // donationType에 따라 userNumber를 조회할 지,
    // userNumber가 묶인 artistNumber를 조회할지 결정해야함)
    // (매개변수로 sortingType을 받아 최신 순, 오래된 순, 금액 높은 순, 금액 낮은 순 선택)
    public List<PaymentVO> getList(@Param("criteria") Criteria criteria, @Param("number") Long number);

   // 목록 개수
    public int getTotal(@Param("number") Long number, @Param("listDTO") ListDTO listDTO);

    // 쿼리 if문
    // 나의 후원 목록, 개수 (최신 순)
    // 나의 후원 목록, 개수 (오래된 순)
    // 나의 후원 목록, 개수 (금액 높은 순)
    // 나의 후원 목록, 개수 (금액 낮은 순)

    // 아티스트 후원 회원 목록, 개수 (최신 순)
    // 아티스트 후원 회원 목록, 개수 (오래된 순)
    // 아티스트 후원 회원 목록, 개수 (금액 높은 순)
    // 아티스트 후원 회원 목록, 개수 (금액 낮은 순)
}
