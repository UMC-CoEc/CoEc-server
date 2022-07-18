package com.umc.coec.domain.purpose;

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
public class Purpose {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long purposeId;

    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private String contents;

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;

}
