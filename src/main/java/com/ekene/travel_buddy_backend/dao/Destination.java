package com.ekene.travel_buddy_backend.dao;

import com.ekene.travel_buddy_backend.dao.filesDto.Image;
import com.ekene.travel_buddy_backend.dao.filesDto.Video;
import com.ekene.travel_buddy_backend.dao.myenum.DestType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Destination{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String state;
    @Enumerated(EnumType.STRING)
    private DestType destType;
    private String description;
    private String localLang;
    @OneToMany
    private List<Image> images;
    @OneToMany
    private List<Video> videos;
    @ManyToMany
    private List<Lodges> availableLodges;
    @ManyToMany
    private List<Guide> availableTourGuide;
    @ManyToMany
    private List<Trans> trans_available;
    @OneToMany
    private List<Review> review;

}
