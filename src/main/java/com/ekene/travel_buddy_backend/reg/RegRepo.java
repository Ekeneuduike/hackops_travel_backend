package com.ekene.travel_buddy_backend.reg;

import com.ekene.travel_buddy_backend.dao.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegRepo extends JpaRepository<RegToken,String> {

    RegToken findBytoken(String token);
}
