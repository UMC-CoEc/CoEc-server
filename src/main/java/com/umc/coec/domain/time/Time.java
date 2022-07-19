package com.umc.coec.domain.time;

import com.umc.coec.domain.enums.Day;
import com.umc.coec.domain.enums.Status;
import com.umc.coec.domain.post.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Time {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    private Status status=Status.ACTIVE;

    @Enumerated(EnumType.STRING)
    private Day day;

    @Comment("운동 시작 시간")
    private LocalDateTime startTime;


    @Comment( "운동 종료 시간")
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;

}
