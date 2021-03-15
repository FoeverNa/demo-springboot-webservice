package com.example.demospringbootwebservice.config.auth.dto;

import com.example.demospringbootwebservice.domain.User;

import java.io.Serializable;

// Serializable을 하기 위해 새로운 SessionUser만들어줌
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }

}
