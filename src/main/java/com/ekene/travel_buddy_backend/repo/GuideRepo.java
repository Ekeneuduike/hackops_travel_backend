package com.ekene.travel_buddy_backend.repo;

import com.ekene.travel_buddy_backend.dao.Guide;
import com.ekene.travel_buddy_backend.dao.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GuideRepo extends JpaRepository<Guide,String> {
    @Query("""
    select g.reviews from Guide g where g.id = ?1
""")
    List<Review> getReviews(String id, Pageable page);
}
