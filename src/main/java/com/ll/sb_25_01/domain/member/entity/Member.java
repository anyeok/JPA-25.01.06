package com.ll.sb_25_01.domain.member.entity;

import com.ll.sb_25_01.global.jpa.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true) // BaseEntity에 있는 ToString 가져옴
public class Member extends BaseEntity {
    private String username;
    private String password;
}
