package com.ekene.travel_buddy_backend.controller;

import com.ekene.travel_buddy_backend.dao.Review;
import com.ekene.travel_buddy_backend.dao.dto.ReviewInfo;
import com.ekene.travel_buddy_backend.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("api/hackops/review")
public class ReviewController {
    private final ReviewService service;
    @GetMapping()
    public List<Review> getReview(@RequestParam String id, String name, int start, int end) {
        Pageable page = PageRequest.of(start,end);
        return service.getReviews(id,name,page);
    }
    @GetMapping("locationReviews")
    public List<Review> getLocationReview(@RequestParam String id) {
     Pageable page = PageRequest.of(0,20);
     return service.getDestinationReviews(id,page);
    }
    @PostMapping("add")
    public String addReview(@RequestBody ReviewInfo review, @RequestParam String userId, String name, String id) {
        return service.addReview(review,userId,name,id);
    }

}
