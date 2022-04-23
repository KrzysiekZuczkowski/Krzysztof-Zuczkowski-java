package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {

    private final int userId;
    private final String userName;
    private final char userSex;
    private final LocalDate dateOfBirth;
    private final int postsPublishedQuantity;

    public ForumUser(final int userId, final String userName,
                     final char userSex, final LocalDate dateOfBirth,
                     final int postsPublishedQuantity) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
        this.dateOfBirth = dateOfBirth;
        this.postsPublishedQuantity = postsPublishedQuantity;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId = " + userId +
                ", userName = '" + userName + '\'' +
                ", userSex = " + userSex +
                ", dateOfBirth = " + dateOfBirth +
                ", postsPublishedQuantity = " + postsPublishedQuantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ForumUser)) return false;

        ForumUser forumUser = (ForumUser) o;

        if (getUserId() != forumUser.getUserId()) return false;
        if (getUserSex() != forumUser.getUserSex()) return false;
        if (getPostsPublishedQuantity() != forumUser.getPostsPublishedQuantity()) return false;
        if (getUserName() != null ? !getUserName().equals(forumUser.getUserName()) : forumUser.getUserName() != null)
            return false;
        return getDateOfBirth() != null ? getDateOfBirth().equals(forumUser.getDateOfBirth()) : forumUser.getDateOfBirth() == null;
    }

    @Override
    public int hashCode() {
        int result = getUserId();
        result = 31 * result + (getUserName() != null ? getUserName().hashCode() : 0);
        result = 31 * result + (int) getUserSex();
        result = 31 * result + (getDateOfBirth() != null ? getDateOfBirth().hashCode() : 0);
        result = 31 * result + getPostsPublishedQuantity();
        return result;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public char getUserSex() {
        return userSex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPostsPublishedQuantity() {
        return postsPublishedQuantity;
    }
}
