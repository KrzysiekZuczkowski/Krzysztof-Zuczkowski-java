package com.kodilla.patterns.prototype.library;

import java.time.LocalDate;

public final class Book {

    private String title;
    private String author;
    final LocalDate publicationDate;

    public Book(final String title, final String author, final LocalDate publicationDate) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    public Book(Book book) {
        this.title = book.title;
        this.author = book.author;
        this.publicationDate = book.publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setBook() {
        title += " *";
        author += " *";
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    @Override
    public String toString() {
        return "   Book[" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationDate=" + publicationDate +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (getTitle() != null ? !getTitle().equals(book.getTitle()) : book.getTitle() != null) return false;
        if (getAuthor() != null ? !getAuthor().equals(book.getAuthor()) : book.getAuthor() != null) return false;
        return getPublicationDate() != null ? getPublicationDate().equals(book.getPublicationDate()) : book.getPublicationDate() == null;
    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
        result = 31 * result + (getPublicationDate() != null ? getPublicationDate().hashCode() : 0);
        return result;
    }
}
