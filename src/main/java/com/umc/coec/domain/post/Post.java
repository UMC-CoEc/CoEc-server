package com.umc.coec.domain.post;

import com.umc.coec.domain.enums.Division;
import com.umc.coec.domain.enums.Gender;
import com.umc.coec.domain.enums.Status;
import com.umc.coec.domain.location.Location;
import com.umc.coec.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sportsId")
    private Sports sports;

    @Column(nullable = false)
    private LocalDate startDate;

    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locationId")
    private Location location;

    @Column(nullable = false)
    private int memberCount;

    private String title;

    @Column(length = 1000)
    private String contents;

    @Column(nullable = false)
    private int ageWanted;

    @Enumerated(EnumType.STRING)
    private Gender genderWanted;

    @OneToMany
    @JoinColumn(name = postJoinId)
    private List<PostJoin> postJoins = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = purposeId)
    private List<Purpose> purposes = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = sportsTimeId)
    private List<SportsTime> sportsTimes = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = interestId)
    private List<Interest> interests = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = chatRoomId)
    private List<ChatRoom> chatRooms = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = reportId)
    private List<Report> reports = new ArrayList<>();
}
