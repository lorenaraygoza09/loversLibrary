package com.org.demo.service.impl;

import com.org.demo.repository.ReviewRepository;
import com.org.demo.service.ReviewService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repository;

    public ReviewServiceImpl(ReviewRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createReview(Long bookId, Object request) {

    }

    @Override
    public void updateReview(Long reviewId, Object request) {

    }

    @Override
    public void deleteReview(Long reviewId) {

    }
}
