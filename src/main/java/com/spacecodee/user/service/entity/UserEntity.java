package com.spacecodee.user.service.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "user", schema = "user-service")
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id", nullable = false)
    private int userId;
    @Basic
    @Column(name = "user_name", nullable = false, length = 150)
    private String userName;
    @Basic
    @Column(name = "user_email", nullable = false, length = 200)
    private String userEmail;

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userId == that.userId && Objects.equals(userName, that.userName) && Objects.equals(
                userEmail, that.userEmail);
    }

    @Override public int hashCode() {
        return Objects.hash(userId, userName, userEmail);
    }
}
