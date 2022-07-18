package com.umc.coec.domain.sports;

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
public class Sports {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long sportsId;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private String sportsName;

    @Column(nullable = false)
    private Boolean isTeamSports;
}