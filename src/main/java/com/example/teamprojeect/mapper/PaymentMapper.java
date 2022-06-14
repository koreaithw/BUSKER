package com.example.teamprojeect.mapper;

import com.example.teamprojeect.domain.vo.Criteria;
import com.example.teamprojeect.domain.vo.PaymentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentMapper {
    // 후원 결제
    public void pay(PaymentVO paymentVO);

    // 후원 결제 취소
    public void refund(Long paymentNumber);

    // 나의 후원 목록 (최신 순)
    public List<PaymentVO> getListNew(Criteria criteria, Long userNumber);
    // 나의 후원 목록 개수 (최신 순)
    public int getTotalPay();

    // 나의 후원 목록 (오래된 순)
    public List<PaymentVO> getListOld(Criteria criteria, Long userNumber);
    // 나의 후원 목록 개수 (오래된 순)

    // 나의 후원 목록 (금액 높은 순)
    public List<PaymentVO> getListExpensive(Criteria criteria, Long userNumber);
    // 나의 후원 목록 개수 (금액 높은 순)

    // 나의 후원 목록 (금액 낮은 순)
    public List<PaymentVO> getListCheap(Criteria criteria, Long userNumber);
    // 나의 후원 목록 개수 (금액 낮은 순)


    // 나의 후원과 아티스트 후원목록 mapper 분리할지?

//    // 아티스트 후원 회원 목록 (최신 순)
//    public List<PaymentVO> getListNew(Criteria criteria, Long artistNumber);
//    // 아티스트 후원 회원 목록 개수 (최신 순)
//
//    // 아티스트 후원 회원 목록 (오래된 순)
//    public List<PaymentVO> getListOld(Criteria criteria, Long artistNumber);
//    // 아티스트 후원 회원 목록 개수 (오래된 순)
//
//    // 아티스트 후원 회원 목록 (금액 높은 순)
//    public List<PaymentVO> getListExpensive(Criteria criteria, Long artistNumber);
//    // 아티스트 후원 회원 목록 개수 (금액 높은 순)
//
//    // 아티스트 후원 회원 목록 (금액 낮은 순)
//    public List<PaymentVO> getListCheap(Criteria criteria, Long artistNumber);
//    // 아티스트 후원 회원 목록 개수 (금액 낮은 순)

}
