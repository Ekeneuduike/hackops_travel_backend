package com.ekene.travel_buddy_backend;

import com.ekene.travel_buddy_backend.dao.Tourist;
import com.ekene.travel_buddy_backend.dao.myenum.Gender;
import com.ekene.travel_buddy_backend.dao.myenum.Role;
import com.ekene.travel_buddy_backend.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@SpringBootApplication
public class TravelBuddyBackendApplication {

	private UserRepo repo;
	private final PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(TravelBuddyBackendApplication.class, args);}

	 @Bean
	 CommandLineRunner commandLineRunner() {
		return args -> {
			repo.save(Tourist.builder().role(Role.ADMIN)
					.email("admin@ekene.com")
					.password(passwordEncoder.encode("admin"))
					.lastname("admin")
					.firstname("ekene")
					.enabled(true)
					.gender(Gender.OTHER)
					.build());
		};
	 }
}
