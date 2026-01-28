package com.org.demo.service;

public interface ReviewService {
    void createReview(Long bookId, Object request);

    void updateReview(Long reviewId, Object request);

    void deleteReview(Long reviewId);
}
