package com.ekene.travel_buddy_backend.controller;


import com.ekene.travel_buddy_backend.dao.*;
import com.ekene.travel_buddy_backend.dao.dto.DestinationDto;
import com.ekene.travel_buddy_backend.repo.DestinationRepo;
import com.ekene.travel_buddy_backend.service.FileService;
import com.ekene.travel_buddy_backend.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/hackops/location")
public class LocationController {
private final LocationService service;

    @PostMapping("add")
   public void addDestination(@RequestPart List<MultipartFile> videos,
                              List<MultipartFile> images, DestinationDto destinationDto) {
        service.addDestination(videos,images,destinationDto);

   }

   @PatchMapping("edit")
   public void editLocation(@RequestParam String id,@RequestPart List<MultipartFile> videos,
                            List<MultipartFile> images, DestinationDto destinationDto){
        service.editLocation(id,videos,images,destinationDto);

   }
   @GetMapping("")
   public DestinationDto getDestination(@RequestParam String id){
       return service.getDestination(id);

   }
   @GetMapping("/getLodges")
   public List<Lodges> getLodges(@RequestParam String id){
       return service.getLodges(id);
   }
   @GetMapping("getGuides")
   public List<Guide> getGuides(@RequestParam String id){
        return service.getGuides(id);
   }
    @GetMapping("getTrans")
   public List<Trans> getTrans(@RequestParam String id){
        return service.getTrans(id);
   }


}
