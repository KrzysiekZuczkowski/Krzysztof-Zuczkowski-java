package com.kodilla.optional;

import com.kodilla.exception.nullpointer.User;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {

        User user = null;

        Optional<User> optionalUser = Optional.ofNullable(user);

        String username = optionalUser.orElse(new User("Seba")).getUsername();

        System.out.println(username);

        optionalUser.ifPresent(u -> System.out.println(u.getUsername()));
    }
}
