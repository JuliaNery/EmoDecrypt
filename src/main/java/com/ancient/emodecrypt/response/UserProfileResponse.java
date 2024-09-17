package com.ancient.emodecrypt.response;


import com.ancient.emodecrypt.entity.UserDocument;

public record UserProfileResponse(
        String email
) {

    public UserProfileResponse(UserDocument user){
        this( user.getEmail());
    }

}
