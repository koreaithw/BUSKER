package com.example.teamprojeect.domain.dao.artist;

import com.example.teamprojeect.domain.vo.artist.PaymentVO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.mapper.artist.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PaymentDAO {
    private final PaymentMapper paymentMapper;

    // 후원 결제
    public void donation(PaymentVO paymentVO) {
        paymentMapper.pay(paymentVO);
    }

    // 후원 결제 취소
    public void cancel(Long paymentNumber) {
        paymentMapper.refund(paymentNumber);
    }

    // 후원 목록
    // (매개변수로 donationType을 받아 내가한후원 / 후원회원목록 선택)
    // (매개변수로 userNumber를 받아 이 번호에 해당하는 정보를 출력.
    // donationType에 따라 userNumber를 조회할 지,
    // userNumber가 묶인 artistNumber를 조회할지 결정해야함)
    // (매개변수로 sortingType을 받아 최신 순, 오래된 순, 금액 높은 순, 금액 낮은 순 선택)
    public List<PaymentVO> getList(@Param("criteria") Criteria criteria, @Param("number") Long number) {
        return paymentMapper.getList(criteria, number);
    }

    // 목록 개수
    public int getTotal(@Param("number") Long number, @Param("listDTO") ListDTO listDTO) {
        return paymentMapper.getTotal(number, listDTO);
    }
}
