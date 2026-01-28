package com.org.demo.controller;

import com.org.demo.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
/*
    @PostMapping("/books/{bookId}/reviews")
    public ResponseEntity<?> createReview(
            @PathVariable Long bookId,
            @RequestBody CreateReviewRequest request){
        return ResponseEntity.ok().build();
    }
 */
}
