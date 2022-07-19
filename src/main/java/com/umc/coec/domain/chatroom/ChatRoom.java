package com.umc.coec.domain.chatroom;

import com.umc.coec.domain.enums.Status;
import com.umc.coec.domain.user.User;
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
public class ChatRoom {

      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Id
      private long id;

      private LocalDateTime createdAt;
      private LocalDateTime updatedAt;

      @Enumerated(EnumType.STRING)
      private Status postUserStatus;

      @Enumerated(EnumType.STRING)
      private String joinUserStatus;


      @JoinColumn(name="postUserId")
      @ManyToOne
      private User postUser;

      @JoinColumn(name="joinUserId")
      @ManyToOne
      private User joinUser;

      @JoinColumn(name="postId")
      @ManyToOne
      private Post post;

}
