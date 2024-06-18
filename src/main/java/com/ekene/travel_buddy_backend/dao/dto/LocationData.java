package com.ekene.travel_buddy_backend.dao.dto;

import com.ekene.travel_buddy_backend.dao.filesDto.ImageDto;
import com.ekene.travel_buddy_backend.dao.filesDto.VideoDto;
import com.ekene.travel_buddy_backend.dao.myenum.DestType;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class LocationData {
    private String name;
    private String state;
    private DestType destType;
    private String description;
    private String localLang;
    private long rating;
    private List<ImageDto> images;
    private List<VideoDto> videos;
}
