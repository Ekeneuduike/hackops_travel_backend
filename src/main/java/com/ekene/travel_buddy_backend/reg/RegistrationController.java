package com.ekene.travel_buddy_backend.reg;


import com.ekene.travel_buddy_backend.dao.dto.RegObject;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/hackops/register")
public class RegistrationController {
    private final RegistrationService service;

      public String register (@RequestBody RegObject regObject){
          return service.register(regObject);
      }

      public String confirm (@RequestParam String token){
          return  service.confirm(token);
      }

      public String regenerate (@RequestParam String token){
          return service.regenerate(token);
      }
}
