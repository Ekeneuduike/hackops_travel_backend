package com.ekene.travel_buddy_backend.service;

import com.ekene.travel_buddy_backend.dao.*;
import com.ekene.travel_buddy_backend.dao.dto.DestinationDto;
import com.ekene.travel_buddy_backend.repo.DestinationRepo;
import com.ekene.travel_buddy_backend.repo.LodgeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@AllArgsConstructor
public class LocationService {
    private final DestinationRepo repo;
    private final FileService fileService;
    private final LodgeRepo lodgeRepo;


    public DestinationDto getDestination(String id) {
        Destination destination = repo.findById(id).orElseThrow(() ->
                new RuntimeException("Destination not found"));
        return   DestinationDto.builder()
                .name(destination.getName())
                .description(destination.getDescription())
                .localLang(destination.getLocalLang())
                .state(destination.getState())
                .rating(destination.getReview().stream().map(Review::getRating)
                        .reduce(0, Integer::sum)/destination.getReview().size())
                .destType(destination.getDestType())
                .images(fileService.getdestImage(destination.getImages()))
                .availableTourGuide(destination.getAvailableTourGuide())
                .videos(fileService.getDestVideo(destination.getVideos()))
                .review(destination.getReview())
                .availableLodges(destination.getAvailableLodges())
                .trans_available(destination.getTrans_available())
                .build();
    }

    public void addDestination(List<MultipartFile> videos, List<MultipartFile> images, DestinationDto destinationDto) {
    }

    public void editLocation(String id, List<MultipartFile> videos, List<MultipartFile> images, DestinationDto destinationDto) {

    }

    public List<Lodges> getLodges(String id) {
        return repo.getLodges(id);
    }

    public List<Guide> getGuides(String id) {
        return repo.getGuides(id);
    }

    public List<Trans> getTrans(String id) {
        return repo.getTrans(id);
    }
}
