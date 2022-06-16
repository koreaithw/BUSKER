package com.example.teamprojeect.domain.dao.user;

import com.example.teamprojeect.domain.vo.artist.ArtistVO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.user.LikeVO;
import com.example.teamprojeect.mapper.user.LikeMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LikeDAO {
    private final LikeMapper likeMapper;

    // 좋아요 등록
    public void register(LikeVO likeVO) {
        likeMapper.insert(likeVO);
    }

    // 좋아요 취소
    // (매개변수로 likeType를 전달해서 'A'(아티스트) 인지 'W'(작품)인지 구분)
    // (매개변수로 typeNumber를 전달해서 해당 type의 number를 입력)
    public boolean remove(@Param("userNumber") Long userNumber, @Param("listDTO") ListDTO listDTO, @Param("number") Long number) {
        return likeMapper.delete(userNumber, listDTO, number) == 1;
    }

    // 좋아요 목록
    // (매개변수로 likeType를 전달해서 'A'(아티스트) 인지 'W'(작품)인지 구분)
    public List<ArtistVO> getListLike(@Param("userNumber") Long userNumber, @Param("listDTO") ListDTO listDTO) {
        return likeMapper.getListLike(userNumber, listDTO);
    }

    // 아티스트, 작품의 좋아요 개수 (매개변수로 likeCategory를 전달해서 'A'(아티스트) 인지 'W'(작품)인지 구분)
    public int getTotal(@Param("number") Long number, @Param("listDTO") ListDTO listDTO) {
        return likeMapper.getTotal(number, listDTO);
    }
}
