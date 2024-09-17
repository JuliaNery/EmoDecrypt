package com.ancient.emodecrypt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "users_password")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDocument {
    @Id
    String id;
    String email;
    String password;
    LocalDateTime createdAt;
}
