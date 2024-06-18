package com.ekene.travel_buddy_backend.dao.filesDto;

import lombok.Data;

@Data
public class ImageDto {
    private byte[] image;
    private String fileType;
}
