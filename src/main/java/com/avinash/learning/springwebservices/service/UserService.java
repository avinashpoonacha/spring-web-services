package com.avinash.learning.springwebservices.service;

import com.avinash.learning.springwebservices.DTO.Users;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class UserService {

    private static List<Users> users = new ArrayList<Users>();

    static {
        users.add(new Users("avi","32","New England Patriots"));
        users.add(new Users("john","31","SFO 49ers"));
        users.add(new Users("tom brady","43","Tampa Bay Buccaneers"));
    }

    public List<Users> findAll()  {
        return users;
    }

    public Users findOne(String age){
        return users.stream().filter(e -> e.getAge().equals(age)).findFirst().orElse(null);
    }

    public Users save(Users user){
        if(user != null ) {
           users.add(user);
           return user;
        }
        return new Users();
    }

    public Users deletebyId(String age)
    {
        Iterator<Users> userIterator = users.iterator();
        while(userIterator.hasNext()) {
            Users user = userIterator.next();
            if (user.getAge().equals(age)){
                userIterator.remove();
                return user;
            }
        }
        return null;
    }
}
