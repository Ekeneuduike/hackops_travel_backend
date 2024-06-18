package com.ekene.travel_buddy_backend.service;

import com.ekene.travel_buddy_backend.dao.Review;
import com.ekene.travel_buddy_backend.dao.Tourist;
import com.ekene.travel_buddy_backend.dao.dto.DestinationDto;
import com.ekene.travel_buddy_backend.repo.DestinationRepo;
import com.ekene.travel_buddy_backend.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class AppService {
private  final DestinationRepo repo;
private final FileService fileService;
    private final UserRepo userRepo;

    public List<DestinationDto> getAllDestination(int start ,int end) {
        Pageable page =  PageRequest.of(start,end);
        List<DestinationDto> list = repo.findAll(page).stream().map(destination -> {
       return  DestinationDto.builder()
                    .name(destination.getName())
                    .state(destination.getState())
                    .description(destination.getDescription())
                    .images(fileService.getdestImage(destination.getImages()))
                    .destType(destination.getDestType())
                    .localLang(destination.getLocalLang())
                    .rating(destination.getReview().stream().map(Review::getRating)
                            .reduce(0, Integer::sum)/destination.getReview().size())
                    .build();
        }).toList();
        return list;
    }

    public List<DestinationDto> search(int start, int end, String name) {
        Pageable page =  PageRequest.of(start,end);
    return  repo.search(name,page).stream().map(destination -> {
            return  DestinationDto.builder()
                    .name(destination.getName())
                    .state(destination.getState())
                    .description(destination.getDescription())
                    .images(fileService.getdestImage(destination.getImages()))
                    .destType(destination.getDestType())
                    .localLang(destination.getLocalLang())
                    .rating(destination.getReview().stream().map(Review::getRating)
                            .reduce(0, Integer::sum)/destination.getReview().size())
                    .build();
        }).toList();

    }

    public Tourist getUser(String name) {
        return userRepo.findByemail(name);
    }
}
