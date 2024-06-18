package com.ekene.travel_buddy_backend.repo;

import com.ekene.travel_buddy_backend.dao.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepo extends JpaRepository<Tourist, String> {
    Tourist findByemail(String email);
}
