package com.ekene.travel_buddy_backend.controller;

import com.ekene.travel_buddy_backend.dao.Tourist;
import com.ekene.travel_buddy_backend.dao.dto.DestinationDto;
import com.ekene.travel_buddy_backend.service.AppService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/hackops/home")
public class AppController{

    private final AppService service;


    @GetMapping("all")
    public List<DestinationDto> getDestination(@RequestParam int start,int end){
        return service.getAllDestination(start,end);
    }
    @GetMapping("search")
    public List<DestinationDto> search(@RequestParam int start,int end,String name){
         return service.search(start,end,name);
    }
    @GetMapping("")
    public Tourist getUser(Principal principal){
        return service.getUser(principal.getName());
    }


}
