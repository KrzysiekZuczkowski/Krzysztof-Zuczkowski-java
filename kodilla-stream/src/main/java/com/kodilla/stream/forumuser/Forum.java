package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> theUsersForumList = new ArrayList<>();

    public Forum() {
        theUsersForumList.add(new ForumUser(1,
                "Karolina",
                'F',
                LocalDate.of(2000, 1, 23),
                5));
        theUsersForumList.add(new ForumUser(2,
                "Karola",
                'F',
                LocalDate.of(2004, 5, 11),
                25));
        theUsersForumList.add(new ForumUser(3,
                "Karol",
                'M',
                LocalDate.of(1998, 9, 17),
                21));
        theUsersForumList.add(new ForumUser(4,
                "Carolina",
                'F',
                LocalDate.of(1992, 7, 11),
                0));
        theUsersForumList.add(new ForumUser(5,
                "Michal",
                'M',
                LocalDate.of(2002, 10, 11),
                25));
        theUsersForumList.add(new ForumUser(6,
                "Jan",
                'M',
                LocalDate.of(2000, 4, 3),
                0));
    }

    public List<ForumUser> getUserList() {return new ArrayList<>(theUsersForumList);}
}
