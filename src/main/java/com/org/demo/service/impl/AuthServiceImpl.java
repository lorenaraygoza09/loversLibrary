package com.org.demo.service.impl;

import com.org.demo.service.AuthService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {
    @Override
    public void register(Object request) {}

    @Override
    public Object login(Object request) {
        return null;
    }
}
