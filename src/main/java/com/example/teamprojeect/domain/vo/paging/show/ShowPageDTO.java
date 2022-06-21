package com.example.teamprojeect.domain.vo.paging.show;

import com.example.teamprojeect.domain.vo.show.ShowVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowPageDTO {
    private List<ShowVO> list;
    private int total;
//    private Criteria criteria;
//
//    private int startPage;
//    private int endPage;
//    private int realEnd;
//    private int pageCount;
//    private boolean prev, next;
//
//    private int total;
//
//    public ShowPageDTO(Criteria criteria, int total) {
//        this(criteria, 10, total);
//    }
//
//    public ShowPageDTO(Criteria criteria, int pageCount, int total) {
//        this.criteria = criteria;
//        this.total = total;
////        현재 페이지를 기준으로 소수점까지 모두 계산하여 보여질 마지막 페이지 번호를 구한다.
//        this.endPage = (int)Math.ceil(criteria.getPageNum() / (double)pageCount) * pageCount;
//        this.startPage = this.endPage - pageCount + 1;
//        this.realEnd = (int)Math.ceil((double)total / criteria.getAmount());
//
//        if(realEnd < this.endPage){
//            this.endPage = realEnd;
//        }
//
//        this.prev = this.startPage > 1;
//        this.next = this.endPage < realEnd;
//    }
}
