package com.ekene.travel_buddy_backend.repo;

import com.ekene.travel_buddy_backend.dao.Lodges;
import com.ekene.travel_buddy_backend.dao.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LodgeRepo  extends JpaRepository<Lodges,String> {

    @Query("""
 select l.reviews from Lodges l where l.id = ?1
""")
    List<Review> getReviews(String id, Pageable page);
}
