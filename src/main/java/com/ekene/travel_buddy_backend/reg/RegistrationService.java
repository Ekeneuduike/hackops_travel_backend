package com.ekene.travel_buddy_backend.reg;

import com.ekene.travel_buddy_backend.dao.Tourist;
import com.ekene.travel_buddy_backend.dao.dto.RegObject;
import com.ekene.travel_buddy_backend.dao.myenum.Role;
import com.ekene.travel_buddy_backend.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RegistrationService implements UserDetailsService {
    private  final PasswordEncoder passwordEncoder;
    private final RegRepo repo;
    private final UserRepo userRepo;

    public String register(RegObject regObject) {

        if(userRepo.findByemail(regObject.getEmail()) != null){
            throw new RuntimeException("Email Already Exists");
        }

        String token = UUID.randomUUID().toString();
        RegToken regToken = RegToken.builder()
                .token(token)
                .issuedAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(10))
                .user(Tourist.builder()
                        .email(regObject.getEmail())
                        .role(Role.USER)
                        .firstname(regObject.getFirstname())
                        .lastname(regObject.getLastname())
                        .password(passwordEncoder.encode(regObject.getPassword()))
                        .build())
                .build();
        repo.save(regToken);

  return "http://localhost:8080/api/hackops/registration/confirm?token="+token;

    }

    public String confirm(String token) {
        RegToken bytoken = repo.findBytoken(token);
        if(bytoken == null){
            return "invalid token";
        }
        else {
            if(!(bytoken.getConfirmedAt() == null)){
                return " your email is already verified";
            }
            else if (bytoken.getExpiresAt().isBefore(LocalDateTime.now())) {
                return "your token has expired click"+
                        "<a href=\"http://43.205.140.67:8181/api/hackerX/registration/regenerate?token="+bytoken.getToken()+
                        "\">here</a>" +
                        " to regenerate confirmation email";
            }
        }
        bytoken.setConfirmedAt(LocalDateTime.now());
        Tourist user = bytoken.getUser();
        user.setEnabled(true);
        repo.save(bytoken);
        return "your account has been confirmed";
    }

    public String regenerate(String token) {
        RegToken token1 = repo.findBytoken(token);
        if (token1 == null) {
            return "invalid token";
        } else {
            if (!(token1.getConfirmedAt() == null)) {
                return "email already confirmed";
            }
            String regToken = UUID.randomUUID().toString();
            RegToken registrationToken = RegToken.builder()
                    .user(token1.getUser())
                    .token(regToken)
                    .issuedAt(LocalDateTime.now())
                    .expiresAt(LocalDateTime.now().plusMinutes(10))
                    .build();
            repo.save(registrationToken);
            return "http://localhost:8080/api/hackerX/registration/confirm?token="+regToken;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepo.findByemail(email);
    }
}
