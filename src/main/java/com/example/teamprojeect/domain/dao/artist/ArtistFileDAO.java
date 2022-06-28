package com.example.teamprojeect.domain.dao.artist;

import com.example.teamprojeect.domain.vo.artist.ArtistFileVO;
import com.example.teamprojeect.mapper.artist.ArtistFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ArtistFileDAO {
    private final ArtistFileMapper artistFileMapper;

    // 아티스트 사진 추가
    public void insert(ArtistFileVO artistFileVO) {
        artistFileMapper.insert(artistFileVO);
    };

    // 아티스트 사진 삭제
    public void delete(Long artistNumber) {
        artistFileMapper.delete(artistNumber);
    };

    // 아티스트 사진 변경
    public void update(ArtistFileVO artistFileVO) {
        artistFileMapper.update(artistFileVO);
    };

    // 아티스트 사진 선택
    public ArtistFileVO find(Long artistNumber) {
        return artistFileMapper.find(artistNumber);
    };
}
