package com.kih.board.springboot.config.auth.dto;

import com.kih.board.springboot.domain.user.User;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

//    public SessionUser(){}

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }

}
