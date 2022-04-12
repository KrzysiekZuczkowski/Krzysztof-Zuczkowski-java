package com.kodilla.testing.forum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ForumUser {

    private String name;
    private String realName;
    private List<ForumPost> posts = new ArrayList<>();
    private List<ForumComment> comments = new LinkedList<>();

    public ForumUser(String name, String realName) {
        // name visible on forum
        this.name = name;
        this.realName = realName;
    }

    public void addPost(String postBody, String author) {
        ForumPost post = new ForumPost(postBody, author);
        posts.add(post);
    }

    public void addComment(ForumPost thePost, String commentBody, String author) {
        ForumComment comment = new ForumComment(thePost, commentBody, author);
        comments.add(comment);
    }

    public int getPostsQuantity() {
        return posts.size();
    }

    public int getCommentsQuantity() {
        return comments.size();
    }

    public ForumPost getForumPost(int postNumber) {
        if (postNumber >= 0 && postNumber < posts.size()) {
            return posts.get(postNumber);
        }
        return null;
    }

    public ForumComment getForumComment(int commentNumber) {
        ForumComment theComment = null;
        if (commentNumber >= 0 && commentNumber < comments.size()) {
            theComment = comments.get(commentNumber);
        }
        return theComment;
    }

    public boolean removePost(ForumPost thePost) {
        if(posts.contains(thePost)) {
            posts.remove(thePost);
            return true;
        }
        return false;
    }

    public boolean removeComment(ForumComment theComment) {
        if(comments.contains(theComment)) {
            comments.remove(theComment);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }
}
