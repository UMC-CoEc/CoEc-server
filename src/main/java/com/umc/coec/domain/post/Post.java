package com.umc.coec.domain.post;

import com.umc.coec.domain.enums.Division;
import com.umc.coec.domain.enums.Gender;
import com.umc.coec.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Post {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long postId;

    @Enumerated(EnumType.STRING)
    private Division division;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "userId")
    private long userId;

    @ManyToOne
    @JoinColumn(name = "sportsId")
    private long sportsId;

    @Column(nullable = false)
    private LocalDate startDate;

    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "locationId")
    private long locationId;

    @Column(nullable = false)
    private int memberCount;

    private String title;

    @Column(length = 1000)
    private String contents;

    @Column(nullable = false)
    private int ageWanted;

    @Enumerated(EnumType.STRING)
    private Gender genderWanted;
}
