package com.ancient.emodecrypt.request;



import com.ancient.emodecrypt.entity.UserDocument;

import java.time.LocalDateTime;

public record UserFormRequest(

        String email,
        String password
) {
    public UserDocument toModel() {
        return UserDocument.builder()
                .email(email)
                .password(password)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
