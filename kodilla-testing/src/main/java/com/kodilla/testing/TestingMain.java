package com.kodilla.testing;

import com.kodilla.testing.forum.ForumPost;

public class TestingMain {

    public static void main(String[] args) {

        ForumPost f1 = new ForumPost("bla bla", "John");
        ForumPost f2 = new ForumPost("bla bla", "John");


        System.out.println("Is f1 equals f2: " + f1.equals(f2));

        Object o = f2;
        boolean bool = o instanceof ForumPost;
        System.out.println("Is o instanceof ForumPost " + bool);
        System.out.println("Is o class ***" + o.getClass().getSimpleName());
        System.out.println("Is f2 class " + f2.getClass());

        Number n = 0;
        Class<? extends Number> c = n.getClass();
        System.out.println(c);
    }
}
