package com.avinash.learning.springwebservices.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WelcomeBean {

    private final String message;

    public WelcomeBean(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "WelcomeBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
