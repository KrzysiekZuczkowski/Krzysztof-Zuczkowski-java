package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.time.LocalDate;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {


        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        expressionExecutor.executeExpression(3, 4, (a, b) ->
                FunctionalCalculator.multiplyAByB(a, b));

        Forum theForumUsersList = new Forum();

        Function<ForumUser, Integer> userId = ForumUser::getUserId;

        Map<Integer, ForumUser> theResultMapOfForumUsers = theForumUsersList.getUserList().stream()
                .filter(forumUser -> forumUser.getUserSex() == 'M')
                .filter(forumUser2 -> LocalDate.now().getYear() -
                        forumUser2.getDateOfBirth().getYear() > 19)
                .filter(forumUser -> forumUser.getPostsPublishedQuantity() > 0)
                .collect(Collectors.toMap(userId, forumUser1 -> forumUser1));

        String theResultStringOfForumUsers = theResultMapOfForumUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining(",\n",
                        "# elements  " + theResultMapOfForumUsers.size() + "\n<< ",
                        " >>"));

        System.out.println(theResultStringOfForumUsers);
    }
}
