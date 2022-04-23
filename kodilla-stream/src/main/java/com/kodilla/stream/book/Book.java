package com.kodilla.stream.book;

public final class Book {

    private final String author;
    private final String title;
    private final int yearOfPublication;
    private final String signature;


    public Book(final String author, final String title,
                final int yearOfPublication, final String signature) {
        this.author = author;
        this.title = title;
        this.signature = signature;
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", signature='" + signature + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getSignature() {
        return signature;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }
}
