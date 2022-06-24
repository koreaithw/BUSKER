package com.example.teamprojeect.domain.vo.paging.donation;

import com.example.teamprojeect.domain.vo.donation.DonationVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationPageDTO {
    private List<DonationVO> list;
    private int total;
}
