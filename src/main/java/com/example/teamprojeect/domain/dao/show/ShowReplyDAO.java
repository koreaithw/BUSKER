package com.example.teamprojeect.domain.dao.show;

import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.show.ShowReplyVO;
import com.example.teamprojeect.mapper.show.ShowReplyMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ShowReplyDAO {
    private final ShowReplyMapper showReplyMapper;

    // 공연 댓글 등록
    public void register(ShowReplyVO showReplyVO) {
        showReplyMapper.insert(showReplyVO);
    }

    // 공연 댓글 수정
    public boolean modify(ShowReplyVO showReplyVO) {
        return showReplyMapper.update(showReplyVO) == 1;
    }

    // 공연 댓글 삭제
    public boolean remove(Long replyNumber) {
        return showReplyMapper.delete(replyNumber) == 1;
    }

    // 공연 댓글 개수
    public int getTotal(Long showNumber) {
        return showReplyMapper.getTotal(showNumber);
    }

    // 공연 댓글 목록
    public List<ShowReplyVO> getList(@Param("criteria") Criteria criteria, @Param("showNumber")Long showNumber) {
        return showReplyMapper.getList(criteria, showNumber);
    }

    // 특정 유저가 쇼에 남긴 댓글 목록
    public List<ShowReplyVO> getUserShowReply(@Param("criteria")Criteria criteria, @Param("userNumber")Long userNumber){
        return showReplyMapper.getUserShowReply(criteria, userNumber);
    }

    // 특정 유저가 쇼에 남긴 댓글 수
    public int getTotalUserShowREply(Long userNumber){
        return showReplyMapper.getTotalUserShowReply(userNumber);
    }
}
