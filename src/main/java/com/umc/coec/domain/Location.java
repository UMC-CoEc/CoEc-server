package com.umc.coec.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Location {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int locationId;

      @CreatedDate
      private LocalDateTime createdAt;

      @LastModifiedDate
      private LocalDateTime updatedAt;


      private BigDecimal latitude;
      private BigDecimal longitude;

      private String siDo;
      private String siGunGu;
      private String eupMyunDongLi;


}
