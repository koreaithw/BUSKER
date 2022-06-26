package com.example.teamprojeect.mapper.show;

import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.show.ShowReplyVO;
import com.example.teamprojeect.domain.vo.show.ShowVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShowReplyMapper {

    // 공연 댓글 등록
    public void insert(ShowReplyVO showReplyVO);

    // 공연 댓글 수정
    public int update(ShowReplyVO showReplyVO);

    // 공연 댓글 삭제
    public int delete(Long replyNumber);

    // 공연 댓글 개수
    public int getTotal(Long showNumber);

    // 공연 댓글 목록
    public List<ShowReplyVO> getList(@Param("criteria") Criteria criteria, @Param("showNumber")Long showNumber);

    // 특정 유저가 공연에 남긴 댓글 목록
    public List <ShowReplyVO> getUserShowReply(@Param("criteria")Criteria criteria, @Param("userNumber")Long userNumber);

    // 특정 유저가 공연에 남긴 댓글 수
    public int getTotalUserShowReply(Long userNumber);
}
