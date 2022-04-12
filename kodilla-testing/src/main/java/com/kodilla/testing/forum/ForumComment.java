package com.kodilla.testing.forum;

public class ForumComment {

    private ForumPost forumPost;
    private String commentBody;
    private String author;

    public ForumComment(ForumPost forumPost, String commentBody, String author) {
        this.forumPost = forumPost;
        this.commentBody = commentBody;
        this.author = author;
    }

    @Override
    public String toString() {
        return "ForumComment{" +
                "forumPost=" + forumPost +
                ", commentBody='" + commentBody + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ForumComment)) return false;

        ForumComment that = (ForumComment) o;

        if (!getForumPost().equals(that.getForumPost())) return false;
        if (!getCommentBody().equals(that.getCommentBody())) return false;
        return getAuthor().equals(that.getAuthor());
    }

    @Override
    public int hashCode() {
        int result = getForumPost().hashCode();
        result = 31 * result + getCommentBody().hashCode();
        result = 31 * result + getAuthor().hashCode();
        return result;
    }

    public ForumPost getForumPost() {
        return forumPost;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public String getAuthor() {
        return author;
    }
}
