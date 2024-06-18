package com.ekene.travel_buddy_backend.repo;

import com.ekene.travel_buddy_backend.dao.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DestinationRepo extends JpaRepository<Destination,String> {

    @Query("""
select c from Destination c where lower(c.name) like lower(concat('%', ?1, '%'))
""")
    List<Destination> search( String name,Pageable page);

    @Query("""
 select d.review from Destination d where d.id = ?1
""")
    List<Review> getReviews(String id, Pageable page);

    @Query("""
select d.availableLodges from Destination d where d.id = ?1
""")
    List<Lodges> getLodges(String id);

    @Query("""
 select d.availableTourGuide from Destination d where d.id = ?1
""")
    List<Guide> getGuides(String id);


    @Query("""
 select d.trans_available from Destination d where d.id = ?1
""")
    List<Trans> getTrans(String id);
}
