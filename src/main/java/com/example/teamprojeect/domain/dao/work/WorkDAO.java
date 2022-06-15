package com.example.teamprojeect.domain.dao.work;

import com.example.teamprojeect.mapper.work.WorkMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class WorkDAO {
    private WorkMapper workMapper;
}
