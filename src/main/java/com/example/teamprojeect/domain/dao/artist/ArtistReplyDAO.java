package com.example.teamprojeect.domain.dao.artist;

import com.example.teamprojeect.domain.vo.artist.ArtistReplyVO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.mapper.artist.ArtistReplyMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ArtistReplyDAO {
    private final ArtistReplyMapper artistReplyMapper;

    // 아티스트 댓글 등록
    public void register(ArtistReplyVO artistReplyVO) {
        artistReplyMapper.insert(artistReplyVO);
    };

    // 아티스트 댓글 수정
    public boolean modify(ArtistReplyVO artistReplyVO) {
        return artistReplyMapper.update(artistReplyVO) == 1;
    };

    // 아티스트 댓글 삭제
    public boolean remove(Long replyNumber) {
        return artistReplyMapper.delete(replyNumber) == 1;
    };

    // 아티스트 댓글 개수
    public int getTotal(Long artistNumber) {
        return artistReplyMapper.getTotal(artistNumber);
    };

    // 아티스트 댓글 목록
    public List<ArtistReplyVO> getList(@Param("criteria") Criteria criteria, @Param("artistNumber")Long artistNumber) {
        return artistReplyMapper.getList(criteria, artistNumber);
    };

    // 유저가 아티스트에게 남긴 댓글 목록
    public List<ArtistReplyVO> getUserReplyList(@Param("criteria")Criteria criteria, @Param("userNumber")Long userNumber){
        return artistReplyMapper.getUserReplyList(criteria, userNumber);
    }

    // 유저가 아티스트에게 남긴 댓글 수
    public int getTotalUserReply(Long userNumber){
        return artistReplyMapper.getTotalUserReply(userNumber);
    }
}
