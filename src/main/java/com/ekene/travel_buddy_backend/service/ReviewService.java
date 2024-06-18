package com.ekene.travel_buddy_backend.service;

import com.ekene.travel_buddy_backend.dao.Review;
import com.ekene.travel_buddy_backend.dao.Tourist;
import com.ekene.travel_buddy_backend.dao.dto.ReviewInfo;
import com.ekene.travel_buddy_backend.repo.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {
    private final TransRepo transRepo;
    private final LodgeRepo lodgeRepo;
    private final GuideRepo guideRepo;
    private final DestinationRepo destinationRepo;
    private final UserRepo userRepo;
    private final ReviewRepo reviewRepo;
    public List<Review> getDestinationReviews(String id, Pageable page) {
        return destinationRepo.getReviews(id,page);

    }

    public List<Review> getReviews(String id,String name, Pageable page) {

        if(name.equalsIgnoreCase("destination")){
            return destinationRepo.getReviews(id,page);
        } else if (name.equalsIgnoreCase("Guide")) {
            return guideRepo.getReviews(id,page);
        } else if (name.equalsIgnoreCase("Lodge")) {
            return lodgeRepo.getReviews(id,page);
        } else if (name.equalsIgnoreCase("Transportation")) {
            return transRepo.getReviews(id,page);
        }
        else {
            return  null;
        }
    }

    public String addReview(ReviewInfo review, String id, String name, String userId) {
        Tourist tourist = userRepo.findById(userId).orElseThrow(
                () -> new RuntimeException("User not found"));
        if(name.equalsIgnoreCase("destination")){
            reviewRepo.save(  Review.builder()
                    .reviewDate(LocalDate.now())
                    .message(review.getMessage())
                    .rating(review.getRating())
                    .Person(tourist)
                    .destination(destinationRepo.findById(id).orElseThrow(()->new RuntimeException("Destination not found")))
                    .build());
        } else if (name.equalsIgnoreCase("lodge")) {
            reviewRepo.save(  Review.builder()
                    .reviewDate(LocalDate.now())
                    .message(review.getMessage())
                    .rating(review.getRating())
                    .Person(tourist)
                    .lodges(lodgeRepo.findById(id).orElseThrow(()->new RuntimeException("lodge not found")))
                    .build());

        }
        else if (name.equalsIgnoreCase("guide")) {
            reviewRepo.save(  Review.builder()
                    .reviewDate(LocalDate.now())
                    .message(review.getMessage())
                    .rating(review.getRating())
                    .Person(tourist)
                    .guide(guideRepo.findById(id).orElseThrow(()->new RuntimeException("guide not found")))
                    .build());

        }
        else if (name.equalsIgnoreCase("Transportation")) {
            reviewRepo.save(  Review.builder()
                    .reviewDate(LocalDate.now())
                    .message(review.getMessage())
                    .rating(review.getRating())
                    .Person(tourist)
                    .trans(transRepo.findById(id).orElseThrow(()->new RuntimeException("transportation not found")))
                    .build());
        }

        return "Review added";
    }
}
