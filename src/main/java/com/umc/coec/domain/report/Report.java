package com.umc.coec.domain.report;

import com.umc.coec.domain.enums.Category;
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
public class Report {

      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Id
      private long id;

      private Status status;

      private LocalDateTime createdAt;
      private LocalDateTime updatedAt;

      @JoinColumn(name="userId")
      @ManyToOne
      private User user;

      @JoinColumn(name="postId")
      @ManyToOne
      private Post post;

      @Enumerated(EnumType.STRING)
      private Category category;

      private String contents;

}
