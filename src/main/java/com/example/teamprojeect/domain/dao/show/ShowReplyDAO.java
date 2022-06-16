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
    public void register(ShowReplyVO artistReplyVO) {
        showReplyMapper.insert(artistReplyVO);
    }

    // 공연 댓글 수정
    public boolean modify(ShowReplyVO artistReplyVO) {
        return showReplyMapper.update(artistReplyVO) == 1;
    }

    // 공연 댓글 삭제
    public boolean remove(Long replyNumber) {
        return showReplyMapper.delete(replyNumber) == 1;
    }

    // 공연 댓글 개수
    public int getTotal(Long artistNumber) {
        return showReplyMapper.getTotal(artistNumber);
    }

    // 공연 댓글 목록
    public List<ShowReplyVO> getList(@Param("criteria") Criteria criteria, @Param("artistNumber")Long artistNumber) {
        return showReplyMapper.getList(criteria, artistNumber);
    }
}
