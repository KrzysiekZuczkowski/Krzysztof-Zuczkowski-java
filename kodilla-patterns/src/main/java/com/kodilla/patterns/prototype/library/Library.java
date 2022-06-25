package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Library extends Prototype<Library> {

    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void filterBooks() {
        books.removeAll(books.stream()
                .filter(b -> b.getPublicationDate().getYear() % 2 == 0)
                .collect(Collectors.toSet()));
    }

    public Book getBook() {
        if(books.size() > 0)
            return books.iterator().next();

        return new Book("no title", "no author", LocalDate.now());
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLib = super.clone();//shallowCopy();
        clonedLib.books = new HashSet<>();
        for(Book book : books) {
            clonedLib.books.add(new Book(book));
        }

        return clonedLib;
    }

    @Override
    public String toString() {
        String s = "Library [" + name + "]";
        for(Book book : books)
            s = s + '\n' + book;

        return s;
    }
}
