package com.example.teamprojeect.domain.vo.paging.work;

import com.example.teamprojeect.domain.vo.paging.Criteria;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class WorkPageDTO {
    private Criteria criteria;

    private int startPage;
    private int endPage;
    private int realEnd;
    private int pageCount;
    private boolean prev, next;

    private int total;

    public WorkPageDTO(Criteria criteria, int total) {
        this(criteria, 10, total);
    }

    public WorkPageDTO(Criteria criteria, int pageCount, int total) {
        this.criteria = criteria; // pageNum 과 amount 불러옴
        this.total = total;
        this.endPage = (int)Math.ceil(criteria.getPageNum() / (double)pageCount) * pageCount;
        // 현재 페이지를 기준으로 소수점까지 모두 계산하여 보여질 마지막 페이지 번호를 구한다.
        this.startPage = this.endPage - pageCount + 1;
        // endPage에서 pageCount를 빼고 1을 더해줌. 즉 n개씩 시작될때 끝페이지 +1 로 다음 묶음 시작
        this.realEnd = (int)Math.ceil((double)total / criteria.getAmount());
        //
        if(realEnd < this.endPage){
            this.endPage = realEnd;
        }

        this.prev = this.startPage > 1;
        this.next = this.endPage < realEnd;
    }
}
