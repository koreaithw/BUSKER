package com.example.teamprojeect.mapper.artist;

import com.example.teamprojeect.domain.vo.artist.ArtistFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArtistFileMapper {
    // 아티스트 사진 추가
    public void insert(ArtistFileVO artistFileVO);

    // 아티스트 사진 삭제
    public void delete(Long artistNumber);

    // 아티스트 사진 변경
    public void update(ArtistFileVO artistFileVO);

    // 아티스트 사진 선택
    public ArtistFileVO find(Long artistNumber);
}
