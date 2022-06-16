package com.example.teamprojeect.service;

import com.example.teamprojeect.domain.dao.user.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserDAO userDAO;
}
