package com.ekene.travel_buddy_backend.dao.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RegObject {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
