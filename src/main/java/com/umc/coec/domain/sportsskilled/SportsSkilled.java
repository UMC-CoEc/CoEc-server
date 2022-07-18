package com.umc.coec.domain.sportsskilled;

import com.umc.coec.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class SportsSkilled {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long sportsSkilledId;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "sportsId")
    private Sports sports;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    private int year;
    private int month;

    @Column(nullable = false)
    private int skilled;

    @Column(length = 1000)
    private String experience;
}
