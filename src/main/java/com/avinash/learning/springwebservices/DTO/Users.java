package com.avinash.learning.springwebservices.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Users {

    private  String name;
    private  String age;
    private  String team;

    public Users(String name, String age, String team) {
        this.name = name;
        this.age = age;
        this.team = team;
    }

    public Users() {
        System.out.println("no user defined");
    }
    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", team='" + team + '\'' +
                '}';
    }
}
