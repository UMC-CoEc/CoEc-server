package com.umc.coec.domain.user;

import com.umc.coec.domain.enums.Gender;
import com.umc.coec.domain.enums.RoleType;
import com.umc.coec.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
//@Table(name = "User_table") //h2 db의 예약어로 User가 있기 때문에 h2 사용할때는 이 어노테이션 활성화
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    @Comment("ACTIVE: 활성화,  INACTIVE: 비활성화,  DELETED: 탈퇴")
    private Status status=Status.ACTIVE;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false,unique = true)
    private String nickname;

    private String phone;
    private String profileImgUrl;
    private String bio;

    @Comment( "USER / ADMIN ")
    @Enumerated(EnumType.STRING)
    private RoleType roleType = RoleType.USER;

    @Comment("계정 만료 여부")
    private Boolean isAccountNonExpired=true;
    @Comment( "계정 잠금 여부")
    private Boolean isAccountNonLocked=true;
    @Comment( "비밀번호 만료 여부")
    private Boolean isCredentialNonExpired=true;
    @Comment("사용 가능 여부")
    private Boolean isEnabled=true;
    @Comment("실명 인증 여부")
    private Boolean isVerified=true;

}
