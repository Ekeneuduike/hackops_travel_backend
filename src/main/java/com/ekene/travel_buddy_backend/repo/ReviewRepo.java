package com.ekene.travel_buddy_backend.repo;

import com.ekene.travel_buddy_backend.dao.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review, String> {
}
