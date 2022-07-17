package com.umc.coec.domain.sportstime;

import com.umc.coec.domain.enums.Day;
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
public class SportsTime {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long sportsTimeId;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Day day;

    private int startTime;
    private int endTime;

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;

}
