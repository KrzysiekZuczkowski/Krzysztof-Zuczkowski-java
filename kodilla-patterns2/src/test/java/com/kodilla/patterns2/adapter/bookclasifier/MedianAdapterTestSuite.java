package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest() {
        //Given
        Book theBook1 = new Book("Assassins' Creed the Book",
                "William Shakespeare", 2000, "test book1");
        Book theBook2 = new Book("Book of jungle", "Rudyard Kipling",
                1750, "test book2");
        Book theBook3 = new Book("50 shades of gray – lexicon for graphicians",
                "Dante Alighieri", 1500, "test book3");
        Book theBook4 = new Book("50 shades of gray – lexicon for graphicians",
                "Dante Alighieri", 1500, "test book3");

        MedianAdapter medianAdapter = new MedianAdapter();
        Set<Book> books = new HashSet<>();
        books.add(theBook1);
        books.add(theBook2);
        books.add(theBook3);
        books.add(theBook4);
        //When
        int medianYear = medianAdapter.publicationYearMedian(books);
        //Then
        assertEquals(1750, medianYear);
        assertEquals(3, books.size());
    }
}