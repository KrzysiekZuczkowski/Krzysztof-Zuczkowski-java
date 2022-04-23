package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {

        Forum theForumUsersList = new Forum();
        Map<Integer, ForumUser> theResultMapOfForumUsers = theForumUsersList.getUserList().stream()
                .filter(forumUser -> forumUser.getUserSex() == 'M')
                .filter(forumUser -> LocalDate.now().getYear() -
                        forumUser.getDateOfBirth().getYear() > 19)
                .filter(forumUser -> forumUser.getPostsPublishedQuantity() > 0)
                .collect(Collectors.toMap(ForumUser :: getUserId, forumUser -> forumUser));

        String theResultStringOfForumUsers = theResultMapOfForumUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining(",\n",
                        "# elements  " + theResultMapOfForumUsers.size() + "\n<< ",
                        " >>"));

        System.out.println(theResultStringOfForumUsers);
    }
}
