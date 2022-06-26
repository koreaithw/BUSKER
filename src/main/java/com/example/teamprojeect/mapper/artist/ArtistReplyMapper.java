package com.example.teamprojeect.mapper.artist;

import com.example.teamprojeect.domain.vo.artist.ArtistReplyVO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArtistReplyMapper {
    // 아티스트 댓글 등록
    public void insert(ArtistReplyVO artistReplyVO);

    // 아티스트 댓글 수정
    public int update(ArtistReplyVO artistReplyVO);

    // 아티스트 댓글 삭제
    public int delete(Long replyNumber);

    // 아티스트 댓글 개수
    public int getTotal(Long artistNumber);

    // 아티스트 댓글 목록
    public List<ArtistReplyVO> getList(@Param("criteria") Criteria criteria, @Param("artistNumber")Long artistNumber);

    // 특정 유저가 아티스트에게 남긴 댓글
    public List <ArtistReplyVO> getUserReplyList(@Param("criteria")Criteria criteria, @Param("userNumber")Long userNumber);

    // 특정 유저가 아티스트에게 남긴 전체 댓글 개수 getUserReplyTotal
    public int getTotalUserReply(Long userNumber);
}
