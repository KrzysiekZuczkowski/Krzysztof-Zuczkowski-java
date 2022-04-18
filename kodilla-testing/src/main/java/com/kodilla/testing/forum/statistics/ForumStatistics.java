package com.kodilla.testing.forum.statistics;

public class ForumStatistics {

    private int numberOfUsers;
    private int numberOfPosts;
    private int numberOfComments;
    private double averageNumberOfPostsPerUser;
    private double averageNumberOfCommentsPerUser;
    private double averageNumberOfCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {
        setNumberOfUsers(statistics.usersNames().size());
        setNumberOfPost(statistics.postsCount());
        setNumberOfComments(statistics.commentsCount());
        if(numberOfUsers != 0) {
            setAverageNumberOfPostsPerUser((double) numberOfPosts / numberOfUsers);
            setAverageNumberOfCommentsPerUser((double) numberOfComments / numberOfUsers);
        }
        if(numberOfPosts != 0)
            setAverageNumberOfCommentsPerPost((double) numberOfComments / numberOfPosts);
    }

    public void showStatistics() {
        System.out.println(this);
        System.out.println();
    }

    @Override
    public String toString() {
        return "ForumStatistics{" +
                "numberOfUsers = " + numberOfUsers +
                ", numberOfPost = " + numberOfPosts +
                ", numberOfComments = " + numberOfComments +
                ", averageNumberOfPostsPerUser = " + averageNumberOfPostsPerUser +
                ", averageNumberOfCommentsPerUser = " + averageNumberOfCommentsPerUser +
                ", averageNumberOfCommentsPerPost = " + averageNumberOfCommentsPerPost +
                '}';
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public void setNumberOfPost(int numberOfPost) {
        this.numberOfPosts = numberOfPost;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(int numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    public double getAverageNumberOfPostsPerUser() {
        return averageNumberOfPostsPerUser;
    }

    public void setAverageNumberOfPostsPerUser(double averageNumberOfPostsPerUser) {
        this.averageNumberOfPostsPerUser = averageNumberOfPostsPerUser;
    }

    public double getAverageNumberOfCommentsPerUser() {
        return averageNumberOfCommentsPerUser;
    }

    public void setAverageNumberOfCommentsPerUser(double averageNumberOfCommentsPerUser) {
        this.averageNumberOfCommentsPerUser = averageNumberOfCommentsPerUser;
    }

    public double getAverageNumberOfCommentsPerPost() {
        return averageNumberOfCommentsPerPost;
    }

    public void setAverageNumberOfCommentsPerPost(double averageNumberOfCommentsPerPost) {
        this.averageNumberOfCommentsPerPost = averageNumberOfCommentsPerPost;
    }
}
