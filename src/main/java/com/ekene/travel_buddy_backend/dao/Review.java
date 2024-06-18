package com.ekene.travel_buddy_backend.dao;

import com.ekene.travel_buddy_backend.dao.myenum.Grade;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @OneToOne
    private Tourist Person;
    private String message;
    private int rating;
    private LocalDate reviewDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private Guide guide;
    @ManyToOne(fetch = FetchType.LAZY)
    private Trans trans;
    @ManyToOne(fetch = FetchType.LAZY)
    private Lodges lodges;
    @ManyToOne(fetch = FetchType.LAZY)
    private  Destination destination;
}
