package com.ekene.travel_buddy_backend.repo;

import com.ekene.travel_buddy_backend.dao.Review;
import com.ekene.travel_buddy_backend.dao.Trans;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransRepo extends JpaRepository<Trans, String> {
    @Query("""
  select t.reviews from Trans t where t.id = ?1
""")
    List<Review> getReviews(String id, Pageable page);
}
