package com.ekene.travel_buddy_backend.reg;


import com.ekene.travel_buddy_backend.dao.Tourist;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class RegToken {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String token;
    private LocalDateTime expiresAt;
    private LocalDateTime issuedAt;
    private LocalDateTime confirmedAt;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private Tourist user;

}
