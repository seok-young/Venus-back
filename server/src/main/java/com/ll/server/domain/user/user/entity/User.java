package com.ll.server.domain.user.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ll.server.global.jpa.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class User extends BaseEntity {
    @Column(unique = true, nullable = false, length = 50)
    String username;

    @Column(unique = true, nullable = false, length = 100)
    String email;


}
