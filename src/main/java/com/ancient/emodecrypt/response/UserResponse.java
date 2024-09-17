package com.ancient.emodecrypt.response;

import com.ancient.emodecrypt.entity.UserDocument;

import java.time.LocalDateTime;

public record UserResponse(
        String id,
        String email,
        LocalDateTime createdAt
) {
    public static UserResponse fromModel(UserDocument user) {
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getCreatedAt()
        );
    }

}
