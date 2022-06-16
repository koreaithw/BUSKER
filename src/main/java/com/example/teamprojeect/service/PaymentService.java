package com.example.teamprojeect.service;

import com.example.teamprojeect.domain.dao.artist.PaymentDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentDAO paymentDAO;
}
