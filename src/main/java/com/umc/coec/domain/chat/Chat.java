package com.umc.coec.domain.chat;

import com.umc.coec.domain.chatroom.ChatRoom;
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
public class Chat {

      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Id
      private long id;

      private LocalDateTime createdAt;
      private LocalDateTime updatedAt;

      private Status status;

      @JoinColumn(name = "chatRoomId")
      @ManyToOne
      private ChatRoom chatRoom;

      @JoinColumn(name="userId")
      @ManyToOne
      private User user;

      @Column(length = 1000)
      private String contents;

}
